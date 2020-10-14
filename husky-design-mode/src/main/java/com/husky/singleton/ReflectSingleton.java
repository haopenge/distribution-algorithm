package com.husky.singleton;

/**
 * @desc 反射破坏单例模式
 * @author liuph
 * @date 2020/10/14 15:59
 */
public class ReflectSingleton {

   private final static ReflectSingleton INSTANCE = new ReflectSingleton();

   private ReflectSingleton(){

   }

   public static ReflectSingleton getInstance(){
        return INSTANCE;
   }
}
