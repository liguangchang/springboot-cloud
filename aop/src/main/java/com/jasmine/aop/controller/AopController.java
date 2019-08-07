package com.jasmine.aop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * aop demo
 *
 * @author lgc guangchang
 * @create 2019-08-07 18:24
 **/

@RestController
public class AopController {

    @GetMapping("/aop")
    public String aopDemo(){
        return "hello aop";
    }
}
