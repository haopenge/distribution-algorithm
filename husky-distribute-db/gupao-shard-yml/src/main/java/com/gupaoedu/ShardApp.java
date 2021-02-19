package com.gupaoedu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: qingshan
 * @Description: 咕泡学院，只为更好的你
 */
@SpringBootApplication
@MapperScan(basePackages = "com.gupaoedu.dao")
public class ShardApp {

    public static void main(String[] args) {
        SpringApplication.run(ShardApp.class, args);
    }

}
