package com.husky.demo.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @desc 使用netty 实现 简易的 http Server 服务
 * @author liuph
 * @date 2021/01/06 11:41
 */
public class NettyHttpServer {
    public static void main(String[] args) {
        new NettyHttpServer().start(8080);
    }

    /**
     * @desc 启动server 服务
     * @author liuph
     * @date  2021/01/06 11:43
     */
    private void start(int port) {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline()
                                .addLast("codec", new HttpServerCodec())                  // HTTP 编解码
                                .addLast("compressor", new HttpContentCompressor())       // HttpContent 压缩
                                .addLast("aggregator", new HttpObjectAggregator(65536))   // HTTP 消息聚合
                                .addLast("handler", new HttpServerHandler());             // 自定义业务逻辑处理器

                    }
                }).childOption(ChannelOption.SO_KEEPALIVE, true);
        ChannelFuture future = null;
        try {
            future = bootstrap.bind(port).sync();
            future.channel().closeFuture().sync();
            System.out.println("...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
}
