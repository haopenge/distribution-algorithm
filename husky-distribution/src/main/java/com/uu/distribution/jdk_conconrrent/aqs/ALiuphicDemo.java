package com.uu.distribution.jdk_conconrrent.aqs;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuph
 * @desc
 * @date 2020/10/26 11:35
 */
public class ALiuphicDemo {
    private static int count = 0;
    static Lock lock = new ReentrantLock();

    public static void inc() {
        lock.lock();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
        lock.unlock();
    }

    public static void main(String[] args) throws
            InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                ALiuphicDemo.inc();
            }).start();
            ;
        }
        Thread.sleep(3000);
        System.out.println("result:" + count);
    }
}
