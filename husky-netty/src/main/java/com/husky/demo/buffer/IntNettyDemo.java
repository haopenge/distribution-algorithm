package com.husky.demo.buffer;

import org.junit.Test;

import java.nio.IntBuffer;

/**
 * @desc
 * @author liuph
 * @date 2020/12/01 15:02
 */
public class IntNettyDemo {

    @Test
    public void test(){
        IntBuffer intBuffer = IntBuffer.allocate(5);
        for (int i = 0; i < intBuffer.capacity(); i++) {
            int j =  2*(i + 1);

            intBuffer.put(j);
        }
        //
        intBuffer.flip();
        while (intBuffer.hasRemaining()){
            int j = intBuffer.get();
             System.out.println(j + "  ");
        }

    }
}
