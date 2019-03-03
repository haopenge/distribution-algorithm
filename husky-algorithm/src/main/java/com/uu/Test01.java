package com.uu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * <pre>
 *
 * 描述：用多线程统计1到100 0000之间有几个素数，并输出这些素数
 *      1. countDownLatch 线程执行完后，减一，countDownLatch.await()阻塞式的
 *      2. 监听方法，需要写监听接口
 * </pre>
 * User Liu PengHao
 * Date 2018/12/20 17:27
 **/
public class Test01 {


    static CountDownLatch countDownLatch = new CountDownLatch(4);

    private static List<Integer> resultList = Collections.synchronizedList(new ArrayList<>());

    /**
     * 判断value是否是素数
     *
     * @param value 要判断的数
     * @return 是 否
     */
    public static boolean isTarget(int value) {
        double sqrt = Math.sqrt(value);
        for (int i = 2; i <= sqrt; i++) {
            int temp = value % i;
            if (temp == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 统计指定范围的内素数线程
     */
    static class CountThread extends Thread {

        /**
         * 开始位置
         */
        private int start;

        /**
         * 结束位置
         */
        private int end;

        public CountThread(String name, int start, int end) {
            super(name);
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            for (int i = start; i <= end; i++) {
                boolean target = isTarget(i);
                if (target) {
                    resultList.add(i);
                }
            }
            countDownLatch.countDown();
        }


    }


    public static void main(String[] args) {
        int block = 1000000 / 4;

        for (int i = 1; i <= 4; i++) {
            CountThread thread = new CountThread("线程" + i, block * (i - 1) + 1, block * i);
            thread.start();
        }
        try {
            countDownLatch.await();
            System.out.println("【数量】：" + resultList.size());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

