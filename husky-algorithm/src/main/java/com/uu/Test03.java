package com.uu;

import java.util.HashMap;

/**
 * 描述：有数组{8,1,13,15,81,23,45}
 * User Liu PengHao
 * Date 2018/12/20 19:40
 **/
public class Test03 {
    private static HashMap<Integer, String> map = new HashMap<Integer, String>(2, 0.75f);

    public static void main(String[] args) {
        map.put(5, "C");

        new Thread("Thread1") {
            @Override
            public void run() {
                map.put(7, "B");
                System.out.println(map);
            }
        }.start();

        new Thread("Thread2") {
            @Override
            public void run() {
                map.put(3, "A");
                System.out.println(map);
            }

        }.start();
    }
}
