package com.husky.demo.timer;

import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author liuph
 * @desc
 * @date 2021/01/28 10:03
 */
public class TimerTest {
    @Test
    public void test32423(){
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
            // do something
                 System.out.println("  I am  so  diao");
            }
        }, 10000, 1000);
    }
    
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // do something
                System.out.println("  I am  so  diao");
            }
        }, 10000, 1000);
    }
}
