package com.husky.proxy.cglib;

import com.husky.proxy.Girl;
import org.junit.Test;

/**
 * @desc cglib 测试
 * @author liuph
 * @date 2020/10/19 17:31
 */
public class CglibTest {
    @Test
    public void test(){
        CglibMeiPo cglibMeiPo = new CglibMeiPo();
        Girl cglibGirl = (Girl) cglibMeiPo.getInstance(Girl.class);
        cglibGirl.findLove();
    }
}
