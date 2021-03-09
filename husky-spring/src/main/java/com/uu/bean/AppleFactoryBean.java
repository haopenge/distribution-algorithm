package com.uu.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @desc
 * @author liuph
 * @date 2021/03/09 14:29
 */
@Component
public class AppleFactoryBean implements FactoryBean<Apple> {


    @Override
    public Apple getObject() throws Exception {
        Apple apple = new Apple();
        apple.setColor(1);
        apple.setWeight(2);
        return apple;
    }

    @Override
    public Class<?> getObjectType() {
        return Apple.class;
    }
}
