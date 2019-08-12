package com.jasmine.solr.service;

import com.jasmine.solr.manager.SolrResult;
import com.jasmine.solr.pojo.User;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;
import java.util.List;

/**
 * @author lgc guangchang
 * @create 2019-08-11 23:46
 **/
public interface SolrService {

    /**
     * 添加索引
     * @param user
     * @return
     * @throws IOException
     * @throws SolrServerException
     */
    SolrResult addDocument(User user) throws IOException, SolrServerException;

    /**
     * 查询索引数量
     * @return
     */
    SolrResult queryAll() throws IOException, SolrServerException;

    SolrResult update() throws IOException, SolrServerException;

    List<User> getData() throws IOException, SolrServerException;

    SolrResult delete(String id) throws IOException, SolrServerException;
}
