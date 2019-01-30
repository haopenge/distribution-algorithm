package com.uu.distribution.JDK并发包.倒计时器;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * <pre>
 *
 * 描述：示例，计算1到100 0000 有多少个素数，并打印这些素数，
 *      注：用多线程解决这个问题,要考虑线程安全问题，cpu四核心
 *
 * 解题思路：
 *      1）先有判断是否为素数的方法
 *      2）启动四个线程，分段求素数，加入在集合中（并发包包裹一下）
 *      3）主线程等待4个线程完毕，输出数据，使用CountDownLatch阻塞主线程
 * </pre>
 * User Liu PengHao
 * Date 2019/01/08 17:20
 **/
public class CountDownLatchDemo {

    private static List<Integer> targets = Collections.synchronizedList(new ArrayList<Integer>());

    private static CountDownLatch countDownLatch = new CountDownLatch(4);

    public static void main(String[] args) {
        int testValue = 1000000;
        int block = testValue/4;
        for (int i = 1; i <= 4; i++) {
            int start = (i -1)*block +1;
            int end =  i*block;

            SearchThread searchThread = new SearchThread("线程" + i, start, end);
            searchThread.start();
        }
        try {
            countDownLatch.await();
            System.out.println("数目：" + targets.size());
            System.out.println("打印：" + targets);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * 判断是否为素数
     *
     * @param value 目标值
     * @return 返回值
     */
    public static boolean isTarget(int value) {
        // 除了1和自身 求余数都不等于0
        double sqrt = Math.sqrt(value);
        for (int i = 2; i <= sqrt; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    static class SearchThread extends Thread {
        public SearchThread(String name, Integer start, Integer end) {
            super(name);
            this.start = start;
            this.end = end;
        }

        private Integer start;
        private Integer end;

        @Override
        public void run() {
            for (int i = start; i <= end; i++) {
                if (isTarget(i)) {
                    targets.add(i);
                }
            }
            countDownLatch.countDown();
        }
    }

}
