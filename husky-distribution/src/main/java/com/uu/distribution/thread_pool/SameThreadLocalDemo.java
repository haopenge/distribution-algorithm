package com.uu.distribution.thread_pool;

/**
 * @desc  threadLocal 使用
 * @author liuph
 * @date 2020/12/02 14:20
 */
public class SameThreadLocalDemo {

    private static final ThreadLocal<String> THREAD_NAME_LOCAL = new ThreadLocal<>();

    private static final ThreadLocal<String> THREAD_NAME_LOCAL_V2 = new ThreadLocal<>();

    public static void main(String[] args) {

        for (int i = 0; i < 2; i++) {

            int tradeId = i;
            new Thread(() -> {

                THREAD_NAME_LOCAL.set("name    " + tradeId);

                THREAD_NAME_LOCAL_V2.set("nameV2  " + tradeId );

                System.out.println("threadName: ...." + THREAD_NAME_LOCAL.get());
                System.out.println("threadName V2：..." + THREAD_NAME_LOCAL_V2.get());

            }, "thread-" + i).start();

        }

    }

    static class TradeOrder {
        long id;
        String status;

        public TradeOrder(int id, String status) {
            this.id = id;
            this.status = status;
        }

        @Override
        public String toString() {
            return "id=" + id + ", status=" + status;
        }
    }
}
