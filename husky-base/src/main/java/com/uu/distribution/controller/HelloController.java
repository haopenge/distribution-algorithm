package com.uu.distribution.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liuph
 * @desc
 * @date 2021/03/19 11:15
 */
@RestController
@RequestMapping("/")
public class HelloController {

    @RequestMapping("hello.do")
    public String hello(HttpServletRequest request){
        return "hello world !  host: " + request.getLocalPort();
    }
}
