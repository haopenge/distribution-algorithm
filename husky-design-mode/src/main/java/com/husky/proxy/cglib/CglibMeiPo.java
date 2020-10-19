package com.husky.proxy.cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @desc  cglib 媒婆代理类
 * @author liuph
 * @date 2020/10/19 16:57
 */
public class CglibMeiPo implements MethodInterceptor {


    public Object getInstance(Class <?> clazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object obj = methodProxy.invokeSuper(o, objects);
        after();
        return obj;
    }

    private void before(){
         System.out.println(" before .....");
    }

    private void after(){
        System.out.println(" after .....");
    }
}
