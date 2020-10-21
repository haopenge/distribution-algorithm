package com.uu.distribution.thread_base.diase_lock;

import org.openjdk.jol.info.ClassLayout;

/**
 * @desc
 * @author liuph
 * @date 2020/10/21 15:50
 */
public class DiasedLockDemo {

    // -XX:BiasedLockingStartupDelay=0
    public static void main(String[] args) throws InterruptedException {

        DiasedLockDemo myClass = new DiasedLockDemo();

        ClassLayout layout = ClassLayout.parseInstance(myClass);

        System.out.println("进入同步代码块之前:");
        System.out.println(layout.toPrintable());


        synchronized (myClass) {
            System.out.println("同步代码块中:");
            System.out.println(layout.toPrintable());
        }

        System.out.println("退出同步代码块后:");
        System.out.println(layout.toPrintable());

    }


}
