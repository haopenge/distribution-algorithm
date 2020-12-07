package com.husky.demo.tomcat;

import com.husky.demo.tomcat.hanlder.PhRequest;
import com.husky.demo.tomcat.hanlder.PhResponse;
import com.husky.demo.tomcat.servlet.PhServlet;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author liuph
 * @desc 手写 tomcat  简易版本
 * @date 2020/12/07 17:25
 */
public class PHTomcat {

    // 核心处理逻辑： ServerSocket   accept
    // 1. 加载配置  生成 url servlet 对应关系

    // 2. 启动Socket, while(true) 处理  {accept()}

    // 3. 将socket.input ,output 转化为 HttpRequest,HttpResponse

    // 4. 从httpRequest中获取用户请求 uri, 匹配对应的Servlet

    // 5. Servlet.service() 处理 ，按method 不同分发给 get、post ...

    // 6. 返回相应数据

    private Map<String, PhServlet> urlServletMap = new HashMap<>();

    private int port = 8080;

    public void loadConfig() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 加载url ,servlet 对应关系
        Properties webProperties = new Properties();

        try (InputStream is = this.getClass().getResourceAsStream("/web_xml.properties")) {
            webProperties.load(is);

            for (Map.Entry<Object, Object> entry : webProperties.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                PhServlet phServlet = (PhServlet) Class.forName(value.toString()).newInstance();

                urlServletMap.put(key.toString(), phServlet);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void start() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        loadConfig();

        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("hp tomcat  启动成功，端口:" + port);
        while (true) {
            Socket socket = serverSocket.accept();
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            PhRequest phRequest = new PhRequest(is);
            PhResponse phResponse = new PhResponse(os);

            String uri = phRequest.getUri();

            PhServlet phServlet = urlServletMap.get(uri);
            phServlet.service(phRequest, phResponse);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        new PHTomcat().start();
    }
}

