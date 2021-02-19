package com.uu.distribution.jdk_conconrrent.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuph
 * @desc
 * @date 2020/11/05 18:50
 */
public class ConditionDemo {

   public static void main(String[] args) {
       Lock lock = new ReentrantLock();
       Condition condition = lock.newCondition();

       lock.newCondition();
       lock.newCondition();
       lock.newCondition();
       lock.newCondition();

       new Thread(new ConditionDemoWait(lock,condition)).start();
       new Thread(new ConditionDemoSignal(lock,condition)).start();
   }
}
