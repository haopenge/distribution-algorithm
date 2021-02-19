package com.uu.distribution.jdk_conconrrent.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author liuph
 * @desc
 * @date 2020/11/05 18:50
 */
public class ConditionDemoSignal implements Runnable{


    private Lock lock;

    private Condition condition;


    public ConditionDemoSignal(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
         System.out.println("ConditionDemoSignal ------>  start");

         try{
             lock.lock();
             condition.signal();

             System.out.println("ConditionDemoSignal ------>  end");

         }catch(Exception e){
             e.printStackTrace();
         }finally {
             lock.unlock();
         }
    }
}
