package com.uu.distribution.jdk_conconrrent.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @desc 重入锁demo
 * @author liuph
 * @date 2020/10/28 19:41
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(false);

        Thread t1 = new Thread("t1"){
            @Override
            public void run() {

                lock.lock();
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 业务逻辑
                 System.out.println("t1 + 逻辑执行中");

                lock.unlock();

            }
        };

        Thread t2 = new Thread("t2"){
            @Override
            public void run() {
                lock.lock();
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 业务逻辑
                System.out.println("t2 + 逻辑执行中");

                lock.unlock();

            }
        };

        Thread t3 = new Thread("t3"){
            @Override
            public void run() {
                lock.lock();
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 业务逻辑
                System.out.println("t3 + 逻辑执行中");

                lock.unlock();

            }
        };

        t1.start();
        t2.start();
        t3.start();


    }
}
