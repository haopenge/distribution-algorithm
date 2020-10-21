package com.uu.distribution.thread_base.diase_lock;

import org.openjdk.jol.datamodel.X86_32_DataModel;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.layouters.HotSpotLayouter;
import org.openjdk.jol.layouters.Layouter;

import java.util.concurrent.TimeUnit;

/**
 * @author liuph
 * @desc
 * @date 2020/10/21 16:04
 */
public class LightWeightLockDemo {
    //不设置立刻启动偏向锁
    public static void main(String[] args) throws InterruptedException {

        Layouter layouter = new HotSpotLayouter(new X86_32_DataModel());

        LightWeightLockDemo myClass = new LightWeightLockDemo();

        ClassLayout layout = ClassLayout.parseInstance(myClass);

        System.out.println("创建t1线程之前:");
        System.out.println(layout.toPrintable());

        Thread t1 = new Thread(() -> {
            synchronized ((myClass)) {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();

        System.out.println("持有锁之前:");
        System.out.println(layout.toPrintable());


        synchronized (myClass) {
            System.out.println("持有锁中:");
            System.out.println(layout.toPrintable());
        }

        System.out.println("释放锁:");
        System.out.println(layout.toPrintable());

        System.out.println("System.gc() 后");
        System.gc();
        System.out.println(layout.toPrintable());

    }


}
