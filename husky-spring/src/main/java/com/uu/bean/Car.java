package com.uu.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationStartupAware;
import org.springframework.core.metrics.ApplicationStartup;
import org.springframework.stereotype.Component;

/**
 * @author liuph
 * @desc
 * @date 2021/02/20 19:16
 */
@Component
public class Car implements ApplicationStartupAware, ApplicationContextAware,BeanNameAware , BeanPostProcessor {

    private ApplicationContext applicationContext;

    private String beanName;

    private ApplicationStartup applicationStartup;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(" --------------------->    3");
        System.out.println(applicationContext.toString());
    }
    @Override
    public void setBeanName(String s) {
        System.out.println(" --------------------->    1");
        s =  "car";
    }

    @Override
    public void setApplicationStartup(ApplicationStartup applicationStartup) {
        System.out.println(" --------------------->    2");
        System.out.println(applicationStartup.toString());
    }
}
