package com.jasmine.solr;

import lombok.extern.slf4j.Slf4j;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
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
@Slf4j
public class SolrApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    SolrClient solrClient;


    @Test
    public String test() throws IOException, SolrServerException {
        /**
         * 创建查询对象
         */
        SolrQuery query = new SolrQuery("name:李广昌");
        QueryResponse response = solrClient.query(query);
        SolrDocumentList results = response.getResults();
        return String.valueOf(results.getNumFound());
    }
}
