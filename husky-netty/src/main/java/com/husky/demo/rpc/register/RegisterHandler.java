package com.husky.demo.rpc.register;

import com.husky.demo.rpc.protocol.InvokerProtocol;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @desc 注册中心
 * @author liuph
 * @date 2020/12/10 21:59
 */
public class RegisterHandler extends ChannelInboundHandlerAdapter {

    // 用于保存所有可用的服务
    public static ConcurrentHashMap<String,Object> registryMap = new ConcurrentHashMap<>();

    // 保存所有相关的服务类
    private List<String> classNames = new ArrayList<>();

    public RegisterHandler(){
        // 完成递归扫描
        scannerClass("com.husky.demo.rpc.provider");
        doRegister();
    }


    /*
     * 递归扫描
     */
    private void scannerClass(String packageName){
        // TODO 可优化
        classNames.add("com.husky.demo.rpc.provider.IHelloServiceImpl");
    }


    /**
     * 完成注册
     */
    private void doRegister(){
        if(classNames.size() == 0){ return; }
        for (String className : classNames) {
            try {
                Class<?> clazz = Class.forName(className);
                Class<?> i = clazz.getInterfaces()[0];
                registryMap.put(i.getName(), clazz.newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Object result = new Object();
        InvokerProtocol request = (InvokerProtocol) msg;

        // 当客户端建立连接时，需要从自定义协议中获取信息，拿到具体的服务和实参
        // 使用反射调用
        if(registryMap.containsKey(request.getClassName())){
            Object clazz = registryMap.get(request.getClassName());
            Method method = clazz.getClass().getMethod(request.getMethodName(), request.getParameters());
            result = method.invoke(clazz,request.getValues());
        }

        ctx.write(result);
        ctx.flush();
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
