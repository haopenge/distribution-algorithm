package com.gupaoedu;

import com.gupaoedu.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: qingshan
 * @Date: 2019/10/21 11:24
 * @Description: 咕泡学院，只为更好的你
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TransactionTest {

    @Autowired
    private UserService userService;

    @Test
    public void transTest() {

        this.userService.testTransactional();
    }
}
