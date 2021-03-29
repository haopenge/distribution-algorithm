package com.uu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc
 * @author liuph
 * @date 2021/03/29 18:48
 */
@RestController
@RequestMapping("/")
public class HelloController {
    @GetMapping("hello")
    public String hello(){
        return "hello";
    }
}
