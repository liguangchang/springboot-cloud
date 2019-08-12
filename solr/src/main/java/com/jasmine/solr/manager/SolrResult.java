package com.jasmine.solr.manager;

import lombok.Data;

/**
 * @author lgc guangchang
 * @create 2019-08-12 19:29
 **/
@Data
public class SolrResult {
   String msg;
   Integer resultCode;

    public SolrResult(String msg, Integer resultCode) {
        this.msg = msg;
        this.resultCode = resultCode;
    }

    public SolrResult(String msg) {
        this.msg = msg;
    }

    public SolrResult(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public SolrResult() {
    }
}
