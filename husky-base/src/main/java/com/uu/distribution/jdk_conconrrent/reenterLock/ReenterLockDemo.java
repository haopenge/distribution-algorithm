package com.uu.distribution.jdk_conconrrent.reenterLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述：
 * User Liu PengHao
 * Date 2019/01/12 11:37
 **/
public class ReenterLockDemo implements Runnable {

    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            lock.lock();
            try {
                i++;
                System.out.println(Thread.currentThread().getName() + " ....");
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLockDemo tl = new ReenterLockDemo();
        Thread t1 = new Thread(tl);
        Thread t2 = new Thread(tl);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(i);

    }
}
