package com.uu.distribution.thread_base.wait;

import org.junit.Test;

import static java.lang.Thread.sleep;

/**
 * @author liuph
 * @desc
 * @date 2020/11/11 10:38
 */
public class WaitAndNotifyDemo {
    @Test
    public void test(){
        Object o = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (o){
                        o.wait();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(".....t1....");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(".....t2....");
                synchronized (o){
                    o.notify();
                }
            }
        });

        t1.start();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
