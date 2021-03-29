package com.uu.service;

/**
 * @desc 用户服务
 * @author liuph
 * @date 2021/03/22 15:24
 */
public interface IUserService {
    String login(String username,String password);

    String getUserInfo(Integer userId);
}
