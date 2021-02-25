package com.uu.dao;


import com.uu.bean.dox.User;
import com.uu.config.DataSourceRouter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    @DataSourceRouter("write")
    Integer insert(User user);

    @DataSourceRouter("read")
    User selectByPrimaryKey(Integer userId);

    @DataSourceRouter("read")
    List<User> find();

    @DataSourceRouter("read")
    User findById(Integer id);
}