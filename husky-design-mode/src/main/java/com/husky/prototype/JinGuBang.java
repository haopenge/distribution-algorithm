package com.husky.prototype;

import java.io.Serializable;

/**
 * @desc 金箍棒
 * @author liuph
 * @date 2020/10/15 17:45
 */
public class JinGuBang implements Serializable {

    public float h = 100;

    public float d = 10;

    public void big(){
        this.d *= 2;
        this.h *=2;
    }

    public void small(){
        this.d /=2;
        this.h /=2;
    }
}
