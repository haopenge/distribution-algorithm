package com.uu.interview20210331;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liuph
 * @desc
 * @date 2021/03/31 22:32
 */
public class ThreadPoolTest {

    
    private static  int cpuCoreSize = Runtime.getRuntime().availableProcessors();
    
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = 
                new ThreadPoolExecutor(cpuCoreSize + 1, cpuCoreSize + 1, 0L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(6));

        threadPoolExecutor.execute(() -> System.out.println(" hello world"));
    
    }
}
