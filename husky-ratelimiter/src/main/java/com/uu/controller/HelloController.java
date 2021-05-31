package com.uu.controller;

import com.uu.annotation.RateLimiter;
import com.uu.annotation.RedisCache;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc
 * @author liuph
 * @date 2021/03/31 10:43
 */
@RestController
@RequestMapping("/")
public class HelloController {

    @GetMapping("hello1.do")
    @RateLimiter(prefixKey = "hello1", limit = 2, expire = 100)
    public String hello1(String api,Integer userId) throws Exception {
        return "正常相应";
    }


    @GetMapping("hello2.do")
    @RateLimiter(prefixKey = "hello2", limit = 2, expire = 100,keys = {"#api","#userId"},fallbackFunction = "helloFallbackFunction",dynamic = true)
    public String hello2(String api,Integer userId) throws Exception {
        return "正常相应";
    }

    public String helloFallbackFunction(String api,Integer userId) throws Exception {
        return "降级相应";
    }

    @GetMapping("hello3.do")
    @RedisCache(prefixKey = "hello3",keys = {"#api","#userId"},expire = 100)
    public String hello3(String api,Integer userId) throws Exception {
        return "正常相应";
    }
}
