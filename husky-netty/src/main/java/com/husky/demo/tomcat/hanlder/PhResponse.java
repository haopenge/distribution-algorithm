package com.husky.demo.tomcat.hanlder;

import java.io.OutputStream;

/**
 * @desc 请求封装
 * @author liuph
 * @date 2020/12/07 17:34
 */
public class PhResponse {

    private OutputStream os;

    public PhResponse(OutputStream os) {
        this.os = os;
    }


    public OutputStream getOs() {
        return os;
    }
}
