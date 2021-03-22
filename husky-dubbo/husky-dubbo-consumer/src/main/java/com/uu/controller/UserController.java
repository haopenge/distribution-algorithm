package com.uu.controller;

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

}
