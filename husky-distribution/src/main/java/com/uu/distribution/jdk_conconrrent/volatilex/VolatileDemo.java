package com.uu.distribution.jdk_conconrrent.volatilex;

/**
 * @author liuph
 * @desc
 * @date 2020/10/23 17:05
 */
public class VolatileDemo {
    public /*volatile*/ static boolean stop = false;

    public static void main(String[] args) throws
            InterruptedException {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (!stop) {
                i++;
            }
        });
        thread.start();
        System.out.println("begin start thread");
        Thread.sleep(1000);
        stop = true;
    }
}
