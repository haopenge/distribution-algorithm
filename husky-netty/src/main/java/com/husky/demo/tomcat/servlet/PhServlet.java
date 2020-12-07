package com.husky.demo.tomcat.servlet;

import com.husky.demo.tomcat.hanlder.PhRequest;
import com.husky.demo.tomcat.hanlder.PhResponse;

import java.io.IOException;

/**
 * @desc 自定义 servlet
 * @author liuph
 * @date 2020/12/07 17:33
 */
public abstract class PhServlet {

    public void service(PhRequest request, PhResponse response) throws IOException {
        if(request.getMethod().equalsIgnoreCase("get")){
            doGet(request,response);
        }else{
            doPost(request,response);
        }
    }

    /**
     * @desc 处理get 请求
     * @author liuph
     * @date  2020/12/07 17:39
     */
    public abstract void doGet(PhRequest request,PhResponse response) throws IOException;

    /**
     * @desc 处理post请求
     * @author liuph
     * @date  2020/12/07 17:39
     */
    public abstract void doPost(PhRequest request,PhResponse response) throws IOException;
}
