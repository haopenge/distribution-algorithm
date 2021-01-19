package com.husky.demo.endecode;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;

import java.nio.charset.StandardCharsets;

/**
 * @desc   编解码器
 * @author liuph
 * @date 2021/01/12 10:53
 */
public class EchoServer {

    public void startEchoServer(int port){
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup work = new NioEventLoopGroup();

        ServerBootstrap b = new ServerBootstrap();
        b.group(work, boss).channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new FixedLengthFrameDecoder(10))
                                .addLast(new EchoServerHandler());
                    }
                });
        ChannelFuture future = null;
        try {
            future = b.bind(port).sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }
    }

    /**
     * @desc 入站处理器
     * @author liuph
     * @date  2021/01/12 11:01
     */
    public class EchoServerHandler extends ChannelInboundHandlerAdapter{
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
             System.out.println(" receive client : ["  +  ((ByteBuf)msg).toString(StandardCharsets.UTF_8) +"]");
        }
    }

    public static void main(String[] args) {
        new EchoServer().startEchoServer(8080);
    }

}
