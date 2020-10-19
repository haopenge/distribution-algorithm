package com.husky.proxy.jdk;

import com.husky.proxy.Girl;
import com.husky.proxy.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @desc 媒婆类
 * @author liuph
 * @date 2020/10/19 12:42
 */
public class JDKMeiPo {

    public static Person getProxyPerson(Girl girl){
        return  (Person) Proxy.newProxyInstance(JDKMeiPo.class.getClassLoader(), Girl.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                before();

                Object object = method.invoke(girl,args);

                after();
                return object;
            }
        });

    }

    public static void before(){
         System.out.println("我是媒婆，说出你的要求");
    }

    public static void after(){
         System.out.println("人已找到，办事吧");
    }
}
