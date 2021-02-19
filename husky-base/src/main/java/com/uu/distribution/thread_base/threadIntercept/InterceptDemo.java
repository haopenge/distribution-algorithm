package com.uu.distribution.thread_base.threadIntercept;

import java.util.concurrent.TimeUnit;

/**
 * 描述：线程中断：
 * User Liu PengHao
 * Date 2019/01/08 16:56
 **/
public class InterceptDemo {
    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(".......我休假了.....");
                    break;
                }
                System.out.println(".......我在工作.....");
            }
        });
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(2);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
