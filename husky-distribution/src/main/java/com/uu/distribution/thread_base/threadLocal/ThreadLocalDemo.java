package com.uu.distribution.thread_base.threadLocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 描述：一人一支笔
 * User Liu PengHao
 * Date 2019/02/18 11:24
 **/
public class ThreadLocalDemo {

    private static final ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<>();

    public static class ParseDate implements Runnable {

        int i = 0;

        public ParseDate(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            if (tl.get() == null) {
                tl.set(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
            }

            try {
                Date date = tl.get().parse("2019-02-22 08:08:" + i % 60);
                System.out.println(i + ":" + date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new ParseDate(i));
        }
    }
}
