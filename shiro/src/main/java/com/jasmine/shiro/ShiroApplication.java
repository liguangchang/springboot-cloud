package com.jasmine.shiro;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lgc
 */
@SpringBootApplication
@MapperScan(basePackages = "com.jasmine.shiro.mapper")
public class ShiroApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ShiroApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }

}
