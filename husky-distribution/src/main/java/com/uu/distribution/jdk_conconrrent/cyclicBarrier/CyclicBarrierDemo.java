package com.uu.distribution.jdk_conconrrent.cyclicBarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * <p>
 * 描述：士兵两人一组对抗训练
 * 步骤1：先自由组队
 * 步骤2：对抗训练
 *
 *
 * </p>
 * User Liu PengHao
 * Date 2019/01/08 18:28
 **/
public class CyclicBarrierDemo {

    public static class Soldier implements Runnable {

        private String soldier;
        private final CyclicBarrier cyclic;

        public Soldier(String soldier, CyclicBarrier cyclic) {
            this.soldier = soldier;
            this.cyclic = cyclic;
        }

        @Override
        public void run() {
            try {
                cyclic.await(); // 先等人 齐了
                doWork(); // 一起干活
                cyclic.await(); // 等所有人都干完活了

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        private void doWork() {
            try {
                Thread.sleep(Math.abs(new Random().nextInt(5) * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(soldier + ": 任务完成");
        }


    }

    static class BarrierAction implements Runnable {

        /**
         * true:集合好了
         * false:任务完成了
         */
        private boolean flag;

        public BarrierAction(boolean flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            if (flag) {
                System.out.println("-----集合完毕-----");
                flag = false;
            } else {
                System.out.println("-----执行完毕-----");
            }
        }
    }

    public static void main(String[] args) {
        final int N = 2;
        CyclicBarrier cyclic = new CyclicBarrier(N, new BarrierAction(true));

        // 设置屏障点，控制线程启动完毕
        System.out.println("集合队伍");
        for (int i = 0; i < 2; i++) {
            System.out.println("士兵 " + i + "报道 ！ ");
            new Thread(new Soldier("士兵" + i, cyclic)).start();
        }

    }
}
