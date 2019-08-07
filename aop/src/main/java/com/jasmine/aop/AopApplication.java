package com.jasmine.aop;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author lgc
 */
@SpringBootApplication

public class AopApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(AopApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }

}
