package com.jasmine.solr.controller;

import com.jasmine.solr.manager.SolrResult;
import com.jasmine.solr.pojo.User;
import com.jasmine.solr.service.SolrService;
import lombok.extern.slf4j.Slf4j;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @author lgc guangchang
 * @create 2019-08-08 23:38
 **/

@RestController
@Slf4j
public class SolrController {

    @Autowired
    SolrService solrService;
    @GetMapping("/add")
    public SolrResult addTest() throws IOException, SolrServerException {
        User user = new User();
        user.setUserId("123");
        user.setName("pgone");
        user.setAddress("小东北");
        user.setGithub("github.com/pgone");
      return   solrService.addDocument(user);
    }

    @GetMapping("/queryAll")
    public SolrResult queryTest() throws IOException, SolrServerException {
        return solrService.queryAll();
    }

    /**
     * 查询文档内容
     * @return
     */
    @GetMapping("/getData")
    public List<User> getData() throws IOException, SolrServerException {
        return solrService.getData();
    }

    @GetMapping("/update")
    public SolrResult update() throws IOException, SolrServerException {
        return solrService.update();
    }

    /**
     * 根据id和条件删除
     * @param id
     * @return
     * @throws IOException
     * @throws SolrServerException
     */
    @GetMapping("/delete")
    public SolrResult delete(String id) throws IOException, SolrServerException {
        return solrService.delete(id);
    }
}

