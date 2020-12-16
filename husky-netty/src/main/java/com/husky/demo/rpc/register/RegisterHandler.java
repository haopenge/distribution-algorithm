package com.husky.demo.rpc.register;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.File;
import java.net.URL;
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

    private void scannerClass(String packageName) {
        URL url = this.getClass().getClassLoader().getResource(packageName.replace("\\.", "/"));
        File dir = new File(url.getFile());
        for (File file : dir.listFiles()) {
            //如果是一个文件夹，继续递归
            if(file.isDirectory()){
                scannerClass(packageName + "." + file.getName());
            }else{
                classNames.add(packageName + "." + file.getName().replace(".class", "").trim());
            }
        }
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
        super.channelRead(ctx, msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
