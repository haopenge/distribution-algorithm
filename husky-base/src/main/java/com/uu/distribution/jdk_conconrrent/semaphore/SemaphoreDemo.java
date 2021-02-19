package com.uu.distribution.jdk_conconrrent.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author liuph
 * @desc
 * @date 2020/11/13 10:00
 */
public class SemaphoreDemo {

    static class Car extends Thread{
        private int num;

        private Semaphore semaphore;

        public Car (int num,Semaphore semaphore){
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("第"+num+"俩车 走喽");
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < 20; i++) {
            new Car(i,semaphore).start();
        }
    }
}
