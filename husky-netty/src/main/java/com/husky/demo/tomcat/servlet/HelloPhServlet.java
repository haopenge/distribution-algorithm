package com.husky.demo.tomcat.servlet;

import com.husky.demo.tomcat.hanlder.PhRequest;
import com.husky.demo.tomcat.hanlder.PhResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @desc  hello servlet 处理
 * @author liuph
 * @date 2020/12/07 18:09
 */
public class HelloPhServlet extends PhServlet {
    /**
     * @desc 处理get 请求
     * @author liuph
     * @date 2020/12/07 17:39
     * @param request request
     * @param response response
     */
    @Override
    public void doGet(PhRequest request, PhResponse response) throws IOException {
        String sb = "HTTP/1.1 200 OK" + "\n" +
                "Content-Type : text/html" + "\n" +
                "\n" +
                "Hello , I am lph";
        response.getOs().write(sb.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * @desc 处理post请求
     * @author liuph
     * @date 2020/12/07 17:39
     * @param request request
     * @param response response
     */
    @Override
    public void doPost(PhRequest request, PhResponse response) throws IOException {

    }
}
