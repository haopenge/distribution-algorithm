package com.uu.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.uu.service.IUserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuph
 * @desc
 * @date 2021/03/22 19:21
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @DubboReference
    private IUserService userService;

    @RequestMapping("/login")
    public String login(String username,String password){
        return userService.login(username,password);
    }

    @RequestMapping("/getUserInfo")
    public String getUserInfo(Integer userId){
       String userInfo = userService.getUserInfo(userId);
       System.out.println("  ..... userInfo :" + userInfo );
       return userInfo;
    }

    @RequestMapping("/getUserInfoWithName")
    @SentinelResource(value = "customer-rule")
    public String getUserInfoWithName(Integer userId){
        String userInfo = userService.getUserInfo(userId);
        System.out.println("  ..... userInfo :" + userInfo );
        return " 异常 ";
    }

    @RequestMapping("/anoLimit")
    @SentinelResource(value = "customer-rule")
    public String anoLimit(){

        return " 异常111 ";
    }

}
