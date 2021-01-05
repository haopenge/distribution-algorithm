package com.husky.demo.rpc.consumer;

import com.husky.demo.rpc.api.IHelloService;
import com.husky.demo.rpc.consumer.proxy.RPCProxy;

/**
 * @desc
 * @author liuph
 * @date 2021/01/05 23:44
 */
public class RpcConsumer {
    public static void main(String[] args) {
         IHelloService rpcHello = RPCProxy.create(IHelloService.class);
         System.out.println(rpcHello.add(1,1));
    }
}
