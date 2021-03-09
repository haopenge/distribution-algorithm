package com.uu.distribution.jdk_conconrrent.reenterLock;

/**
 * @desc
 * @author liuph
 * @date 2021/03/05 17:08
 */
public class SingleThreadDeadDemo {
    public synchronized void demo(){
        System.out.println("begin:demo");
        demo2();
    }
    public void demo2(){
        System.out.println("begin:demo1");
        synchronized (this){
             System.out.println(" 123  ");
        }

    }
    public static void main(String[] args) {
        SingleThreadDeadDemo rd=new SingleThreadDeadDemo();
        new Thread(rd::demo).start();
    }

}
