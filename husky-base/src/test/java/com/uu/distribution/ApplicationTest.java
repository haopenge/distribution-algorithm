package com.uu.distribution;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述：
 * User Liu PengHao
 * Date 2019/01/29 19:30
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootStart.class)
public class ApplicationTest {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void insertDate() {
        redisTemplate.opsForValue().set("name", "不错啊");
    }

    @Test
    public void getData() {
        String token = redisTemplate.boundValueOps("name").get();
        System.out.println(token);
    }

}

