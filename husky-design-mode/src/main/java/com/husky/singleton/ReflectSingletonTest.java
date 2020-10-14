package com.husky.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author liuph
 * @desc 反射破坏单例模式
 * @date 2020/10/14 16:15
 */
public class ReflectSingletonTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<ReflectSingleton> constructor = ReflectSingleton.class.getDeclaredConstructor();
        // 强制进入 （-_-）
        constructor.setAccessible(true);

        ReflectSingleton r1 = constructor.newInstance();

        ReflectSingleton r2 = ReflectSingleton.getInstance();

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r1 == r2);

    }
}
