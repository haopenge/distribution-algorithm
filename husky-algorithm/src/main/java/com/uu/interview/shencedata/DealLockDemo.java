package com.uu.interview.shencedata;

/**
 * @author liuph
 * @desc 死锁
 * @date 2021/03/01 09:36
 */
public class DealLockDemo {


    //  sync 机制，嵌套产生死锁
    //
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();


    public static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(" thread1 get  lock1");
                synchronized (lock2) {
                    System.out.println(" thread1 get  lock2");
                }
            }
        }
    }

    public static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (lock2) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(" thread2 get  lock2");
                synchronized (lock1) {
                    System.out.println(" thread2 get  lock1");
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }
}
