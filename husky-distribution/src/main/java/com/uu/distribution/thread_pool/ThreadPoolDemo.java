package com.uu.distribution.thread_pool;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author liuph
 * @desc
 * @date 2020/12/02 14:20
 */
public class ThreadPoolDemo {

    @Test
    public void test(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(16));


        ExecutorService executorService = Executors.newSingleThreadExecutor();

    }
}
