package com.uu.distribution.jdk_conconrrent.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author liuph
 * @desc
 * @date 2020/11/05 18:50
 */
public class ConditionDemoWait implements Runnable{


    private Lock lock;

    private Condition condition;


    public ConditionDemoWait(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
         System.out.println("ConditionDemoWait ------>  start");

         try{
             lock.lock();
             condition.await();

             System.out.println("ConditionDemoWait ------>  end");

         }catch(Exception e){
             e.printStackTrace();
         }finally {
             lock.unlock();
         }
    }
}
