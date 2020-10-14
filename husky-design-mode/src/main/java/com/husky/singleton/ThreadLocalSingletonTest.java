package com.husky.singleton;

/**
 * @desc threadLocal 形式的 单例
 * @author liuph
 * @date 2020/10/14 17:17
 */
public class ThreadLocalSingletonTest {

    public static void main(String[] args) {
         System.out.println(ThreadLocalSingleton.getInstance());
         System.out.println(ThreadLocalSingleton.getInstance());
         System.out.println(ThreadLocalSingleton.getInstance());
         System.out.println(ThreadLocalSingleton.getInstance());

         //new Thread(new ExectorThread());

        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println(ThreadLocalSingleton.getInstance());
            }
        };
        thread.start();
    }

}
