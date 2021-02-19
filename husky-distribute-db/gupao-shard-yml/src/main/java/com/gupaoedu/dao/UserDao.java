package com.gupaoedu.dao;

import com.gupaoedu.entity.User;

/**
 * @Author: qingshan
 * @Description: 咕泡学院，只为更好的你
 */
public interface UserDao  {

    void addOne(User user);

    User getOneById(long id);
}
