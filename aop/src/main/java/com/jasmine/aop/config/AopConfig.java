package com.jasmine.aop.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * aop config
 *
 * @author lgc guangchang
 * @create 2019-08-07 18:25
 **/
@Component
@Aspect
@Slf4j
public class AopConfig {
    @Pointcut("execution(public * com.jasmine.aop.controller.AopController.aopDemo())")
//    @Pointcut("execution(public * com.example.aop..*.*(..))")
    public void pointcut() { }

    @Before("pointcut()")
    public void before(){
        log.info("before ---");
    }

}
