package com.husky.strategy;

import org.junit.Test;

/**
 * @desc
 * @author liuph
 * @date 2020/05/09 10:27
 */
public class OnlyTest {

    @Test
    public void test33(){
        Share share = new Share();
        share.shareOptions("Sina");
        share.shareOptions("WeChat");
    }
}
