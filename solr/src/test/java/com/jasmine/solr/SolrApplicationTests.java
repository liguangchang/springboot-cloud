package com.jasmine.solr;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class SolrApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    SolrClient solrClient;


    @Test
    public void test() throws IOException, SolrServerException {

        // 连接solr服务器
//       HttpSolrServer httpSolrServer = new SolrClient("http://localhost:8090/solr/collection1");
        // 创建一个查询条件
        SolrQuery solrQuery = new SolrQuery();
        // 设置查询条件
        solrQuery.setQuery("*:*");
        // 设置分页
        solrQuery.setStart(1);
        solrQuery.setRows(10);
        // 执行查询
        QueryResponse query = solrClient.query(solrQuery);
        // 取查询结果
        SolrDocumentList solrDocumentList = query.getResults();

        System.out.println("总记录数：" + solrDocumentList.getNumFound());

        for (SolrDocument sd : solrDocumentList) {
            System.out.println(sd.get("userId"));
            System.out.println(sd.get("name"));
            System.out.println(sd.get("address"));
            System.out.println(sd.get("github"));
//        }
//        QueryResponse query = solrClient.query(new SolrQuery("name:李广昌"));
//        SolrDocumentList results = query.getResults();
//        System.out.println(results);
        }


    }
}
