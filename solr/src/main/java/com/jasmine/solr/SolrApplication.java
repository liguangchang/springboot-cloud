package com.jasmine.solr;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lgc
 */
@SpringBootApplication
public class SolrApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SolrApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }

}
