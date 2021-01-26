package com.uu.distribution.thread_pool;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.concurrent.FastThreadLocalThread;

/**
 * @author liuph
 * @desc
 * @date 2021/01/25 18:53
 */
class FastThreadLocalDemo {

    private static final FastThreadLocal<String> THREAD_NAME_LOCAL = new FastThreadLocal<String>(){
        @Override
        protected String initialValue() throws Exception {
            return "hello world";
        }
    };

    private static final FastThreadLocal<ThreadPoolDemo.TradeOrder> TRADE_THREAD_LOCAL = new FastThreadLocal<>();

    public static void main(String[] args) {

        for (int i = 0; i < 2; i++) {

            int tradeId = i;

            String threadName = "thread-" + i;

            new FastThreadLocalThread(() -> {

           //     THREAD_NAME_LOCAL.set(threadName);

                ThreadPoolDemo.TradeOrder tradeOrder = new ThreadPoolDemo.TradeOrder(tradeId, tradeId % 2 == 0 ? "已支付" : "未支付");

                TRADE_THREAD_LOCAL.set(tradeOrder);

                System.out.println("threadName: " + THREAD_NAME_LOCAL.get());

                System.out.println("tradeOrder info：" + TRADE_THREAD_LOCAL.get());

            }, threadName).start();

        }

    }

}

