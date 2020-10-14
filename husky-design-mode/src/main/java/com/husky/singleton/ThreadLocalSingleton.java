package com.husky.singleton;

/**
 * @desc threadLocal 形式的 单例
 * @author liuph
 * @date 2020/10/14 17:17
 */
public class ThreadLocalSingleton {
    private static final ThreadLocal<ThreadLocalSingleton> threadLocalInstance = new ThreadLocal<ThreadLocalSingleton>(){
        @Override
        protected ThreadLocalSingleton initialValue() {
            return super.initialValue();
        }
    };


    private ThreadLocalSingleton (){

    }


    public static ThreadLocalSingleton getInstance(){
        return threadLocalInstance.get();
    }

}
