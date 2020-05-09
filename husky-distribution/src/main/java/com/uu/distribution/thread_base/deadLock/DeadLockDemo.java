package com.uu.distribution.thread_base.deadLock;

/**
 * 描述：
 * User Liu PengHao
 * Date 2019/01/08 16:40
 **/
public class DeadLockDemo {

    private static Object syncA = new Object();
    private static Object syncB = new Object();

    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        threadA.start();
        threadB.start();
    }

    static class ThreadA extends Thread {
        @Override
        public void run() {
            while (true){
                System.out.println("A----->开始");
                synchronized (syncA) {
                    synchronized (syncB) {
                        System.out.println("A----->执行");
                    }
                }
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            while (true){
                System.out.println("B----->开始");
                synchronized (syncB) {

                    synchronized (syncA) {
                        System.out.println("B----->执行");
                    }
                }
            }
        }
    }
}


