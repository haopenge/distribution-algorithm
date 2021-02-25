package com.uu.mybatis.official;


import java.util.List;

public interface UserDao {
    User selectByPrimaryKey(Integer userId);


    List<User> find();

    User findById(Integer id);
}