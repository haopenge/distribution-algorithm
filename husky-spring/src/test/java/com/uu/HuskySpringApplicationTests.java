package com.uu;

import com.uu.bean.Apple;
import com.uu.bean.dox.User;
import com.uu.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HuskySpringApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    private UserDao userDao;

    @Test
    public void test() {
        User user = new User();
        user.setPhone(12138);
        user.setRemark("test1");
        userDao.insert(user);
    }

    @Autowired
    private Apple apple;

    @Test
    public void test2() {
        System.out.println(apple.toString());
    }


}
