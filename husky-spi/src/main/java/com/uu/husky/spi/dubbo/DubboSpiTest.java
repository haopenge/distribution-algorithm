package com.uu.husky.spi.dubbo;

import com.uu.husky.spi.dubbo.service.IComputer;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.rpc.Protocol;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author liuph
 * @desc dubbo spi 测试
 * @date 2021/03/18 10:27
 */
public class DubboSpiTest {


    /**
     * @desc 指定名称扩展点
     * @author liuph
     * @date 2021/03/18 11:52
     */
    @Test
    public void testNameExtension() {
        IComputer mac = ExtensionLoader.getExtensionLoader(IComputer.class).getExtension("mac");
        mac.coding();

        IComputer windows = ExtensionLoader.getExtensionLoader(IComputer.class).getExtension("windows");
        windows.coding();
    }

    /**
     * @desc 自适应扩展点
     * @author liuph
     * @date 2021/03/18 11:53
     */
    @Test
    public void testAdapterExtension(){
       // Compiler compiler = ExtensionLoader.getExtensionLoader(Compiler.class).getAdaptiveExtension();
       // System.out.println(compiler.toString());

       // IComputer computer = ExtensionLoader.getExtensionLoader(IComputer.class).getAdaptiveExtension();
       // computer.coding();

        Protocol protocol = ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension();
        System.out.println(protocol.getDefaultPort());
    }


    /**
     * @desc 自动激活扩展点  【按条件加载】
     * @author liuph
     * @date 2021/03/18 11:52
     */
    @Test
    public void testActiveExtension() {
        ExtensionLoader<IComputer> loader = ExtensionLoader.getExtensionLoader(IComputer.class);
        URL url = new URL("", "", 0);
        url=url.addParameter("linux","linux");
        List<IComputer> filters = loader.getActivateExtension(url, "","c++");
        System.out.println(filters.size());
        filters.forEach(System.out::println);

    }


}
