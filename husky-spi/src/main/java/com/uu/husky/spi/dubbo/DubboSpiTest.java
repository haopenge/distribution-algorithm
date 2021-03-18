package com.uu.husky.spi.dubbo;

import org.apache.dubbo.common.compiler.Compiler;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.rpc.Protocol;
import org.junit.jupiter.api.Test;

/**
 * @author liuph
 * @desc dubbo spi 测试
 * @date 2021/03/18 10:27
 */
public class DubboSpiTest {

    
    /**
     * @desc 指定名称扩展点
     * @author liuph
     * @date  2021/03/18 11:52
     */
    @Test
    public void testNameExtension (){
        Protocol protocol = ExtensionLoader.getExtensionLoader(Protocol.class).getExtension("myProtocol");
        System.out.println(protocol.getDefaultPort());

    }

    /**
     * @desc 自适应扩展点
     * @author liuph
     * @date  2021/03/18 11:53
     */
    @Test
    public void testAdapterExtension(){
        Compiler compiler = ExtensionLoader.getExtensionLoader(Compiler.class).getAdaptiveExtension();
        System.out.println(compiler.toString());
    }
}
