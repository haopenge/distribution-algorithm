package com.husky.demo.rpc.register;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpResponseDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

/**
 * @desc  注册中心
 * @author liuph
 * @date 2020/12/10 22:00
 */
public class Registry {

    private int port;

    public Registry(int port){
        this.port = port;
    }

    public static void main(String[] args) {
        new Registry(8080).start();
    }

    private  void start() {

        // Reactor模型，Boss,work
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();

        // Netty服务，ServerSocketChannel
        ServerBootstrap server = new ServerBootstrap();

        server.group(bossGroup, workGroup)
                // 主线程处理类，底层反射
                .channel(NioServerSocketChannel.class)
                // 子线程处理类，Handler
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel client) throws Exception {
                        // 无锁化串行编程, 顺序
                        client.pipeline()
                                .addLast(new HttpResponseEncoder())
                                .addLast(new HttpResponseDecoder())
                                .addLast(

                                )
                        ;

                    }
                });
        // TODO 待补充
                //.option()
               // .childOption();


    }
}
