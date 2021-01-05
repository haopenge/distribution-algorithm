package com.husky.demo.rpc.consumer.proxy;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @desc 代理类handler
 * @author liuph
 * @date 2021/01/05 22:49
 */
public class ProxyHandler extends ChannelInboundHandlerAdapter {

    private Object response;

    public Object getResponse(){
        return response;
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        response = msg;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
         System.out.println(" client exception is general");
    }
}
