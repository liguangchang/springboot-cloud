package com.jasmine.solr.service.impl;

import com.jasmine.solr.manager.SolrResult;
import com.jasmine.solr.pojo.User;
import com.jasmine.solr.service.SolrService;
import lombok.extern.slf4j.Slf4j;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author lgc guangchang
 * @create 2019-08-11 23:44
 **/
@Service
@Slf4j
public class SolrServiceImpl implements SolrService {

    @Autowired
    SolrClient solrClient;

    /**
     * 添加索引
     *
     * @param user
     * @return
     * @throws IOException
     * @throws SolrServerException
     */
    @Override
    public SolrResult addDocument(User user) throws IOException, SolrServerException {
        // 创建一个文档对象, 向文档中添加域，必须有id域，域的名称必须在scheme.xml中定义
        SolrInputDocument document = new SolrInputDocument();
        document.addField("userId", user.getUserId());
        document.addField("name", user.getName());
        document.addField("address", user.getAddress());
        document.addField("github", user.getGithub());
        document.addField("id", "1234");
        // 把文档对象写入索引库
        solrClient.add(document);
        // 提交
        solrClient.commit();
        return new SolrResult("success", 200);
    }

    /**
     * 查询索引数量
     *
     * @return
     */
    @Override
    public SolrResult queryAll() throws IOException, SolrServerException {
        SolrQuery query = new SolrQuery("*:*");
        QueryResponse queryResponse = solrClient.query(query);
        return new SolrResult((int) queryResponse.getResults().getNumFound());

    }

    /**
     * 更新 id不变 覆盖
     *
     * @return
     * @throws IOException
     * @throws SolrServerException
     */
    @Override
    public SolrResult update() throws IOException, SolrServerException {
        SolrInputDocument document = new SolrInputDocument();
        document.addField("userId", "1234");
        document.addField("name", "ipad pro");
        document.addField("address", "apple");
        document.addField("github", "apple.ipad");
        document.addField("id", "1234");
        // 把文档对象写入索引库
        solrClient.add(document);
        // 提交
        solrClient.commit();
        return new SolrResult("success", 200);
    }

    /**
     * 查询文档内容
     *
     * @return
     */
    @Override
    public List<User> getData() throws IOException, SolrServerException {
        SolrQuery query = new SolrQuery();
        query.setQuery("*:*");
        query.setStart(1);
        query.setRows(10);
        //开启高亮
        query.setHighlight(true);
        query.addHighlightField("address");
        query.setHighlightSimplePre("<font color='red'>");
        query.setHighlightSimplePost("</font>");
        QueryResponse response = solrClient.query(query);
        SolrDocumentList solrDocumentList = response.getResults();
        log.error("总记录数：" + solrDocumentList.getNumFound());
        List<User> list = new ArrayList<>(11);
        /**
         * 高亮结果集
         */
        Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
        log.error("高亮结果集 "+highlighting.size());
        //TODO 高亮结果集数量和总的数量不一致
        for (SolrDocument sd : solrDocumentList) {
            User user = new User();
            user.setUserId((String) sd.get("userId"));
            user.setName(String.valueOf( sd.get("name")));
            //TODO 使用（String） java.lang.ClassCastException: java.util.ArrayList cannot be cast to java.lang.String
            user.setAddress((String) sd.get("address"));
            user.setGithub((String) sd.get("github"));
            list.add(user);
        }
        return list;
//        return list.stream().sorted(Comparator.comparing(User::getUserId));
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @Override
    public SolrResult delete(String id) throws IOException, SolrServerException {
        /**
         * 根据id删除
         */
        solrClient.deleteById("1234");
        /**
         * 根据条件删除
         */
        solrClient.deleteByQuery("name:'李广昌'");
        // 提交
        solrClient.commit();
        return new SolrResult(200);
    }
}
