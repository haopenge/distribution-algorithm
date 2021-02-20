package com.uu.bean;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * @author liuph
 * @desc
 * @date 2021/02/20 19:16
 */
@Component
public class Car implements BeanNameAware {

    @Override
    public void setBeanName(String s) {
        s =  "car";
    }
}
