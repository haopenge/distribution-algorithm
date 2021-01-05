package com.husky.demo.rpc.register;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

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
        ServerBootstrap bootServer = new ServerBootstrap();

        bootServer.group(bossGroup, workGroup)
                // 主线程处理类，底层反射
                .channel(NioServerSocketChannel.class)
                // 子线程处理类，Handler
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel client) throws Exception {
                        //自定义协议解码器
                        client.pipeline()
                                /** 入参有5个，分别解释如下
                                 maxFrameLength：框架的最大长度。如果帧的长度大于此值，则将抛出TooLongFrameException。
                                 lengthFieldOffset：长度字段的偏移量：即对应的长度字段在整个消息数据中得位置
                                 lengthFieldLength：长度字段的长度。如：长度字段是int型表示，那么这个值就是4（long型就是8）
                                 lengthAdjustment：要添加到长度字段值的补偿值
                                 initialBytesToStrip：从解码帧中去除的第一个字节数
                                 */
                                .addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE,0,4,0,4))
                                .addLast(new LengthFieldPrepender(4))
                                .addLast("encoder",new ObjectEncoder())
                                .addLast("decoder",new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)))
                                .addLast(new RegisterHandler())
                        ;

                    }
                })
                .option(ChannelOption.SO_BACKLOG,128)
                .childOption(ChannelOption.SO_KEEPALIVE,true);


        try {
            ChannelFuture future = bootServer.bind(port).sync();
            System.out.println(" LPH RPC Register start listen at " + port);
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }

    }



}
