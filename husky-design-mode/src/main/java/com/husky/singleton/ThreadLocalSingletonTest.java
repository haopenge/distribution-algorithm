package com.husky.singleton;

/**
 * @desc threadLocal 形式的 单例
 * @author liuph
 * @date 2020/10/14 17:17
 */
public class ThreadLocalSingletonTest {
    private static final ThreadLocal<ThreadLocalSingletonTest> threadLocalInstance = new ThreadLocal<ThreadLocalSingletonTest>(){
        @Override
        protected ThreadLocalSingletonTest initialValue() {
            return super.initialValue();
        }
    };


    private ThreadLocalSingletonTest(){

    }


    public static ThreadLocalSingletonTest getInstance(){
        return threadLocalInstance.get();
    }

}
