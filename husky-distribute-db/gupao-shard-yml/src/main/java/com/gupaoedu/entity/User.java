package com.gupaoedu.entity;


import lombok.Data;

/**
 * @Author: qingshan
 * @Description: 咕泡学院，只为更好的你
 */
@Data
public class User {

    private long userId;
    private String name;
    private int age;

    public User() {
    }

    public User(long userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
    }
}
