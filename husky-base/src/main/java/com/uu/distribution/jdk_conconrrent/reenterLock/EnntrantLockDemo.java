package com.uu.distribution.jdk_conconrrent.reenterLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述：
 * User Liu PengHao
 * Date 2019/01/12 11:44
 **/
/**
 * @author liupenghao 锁中断 机制：
 *
 * 	中断相应： 一个线程在等待的时候如果 超过一定时间就自动 退出不在等待
 * 		lockInterruptibly(): 可以申请锁，在等待时可以相应中断
 * 		interrupt()： 中断当前线程，并释放锁
 */
public class EnntrantLockDemo implements Runnable {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    public EnntrantLockDemo(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            //依次中断lock1,lock2
            if (lock == 1) {
                lock1.lockInterruptibly();

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    lock2.lockInterruptibly();
                }
            }else{

                lock2.lockInterruptibly();
                try{
                    Thread.sleep(500);
                }catch(InterruptedException e ){
                    lock1.lockInterruptibly();
                }

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(lock1.isHeldByCurrentThread()){
                lock1.unlock();// 解锁新姿势
            }
            if(lock2.isHeldByCurrentThread()){
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getName() + ": 线程退出 ");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        EnntrantLockDemo lock1 = new EnntrantLockDemo(1);
        EnntrantLockDemo lock2 = new EnntrantLockDemo(2);
        Thread t1 = new Thread(lock1,"1");
        Thread t2 = new Thread(lock2,"2");
        t1.start();t2.start();
      //  Thread.sleep(1000);

        // 中断其中一个线程
        t2.interrupt();

    }
}
