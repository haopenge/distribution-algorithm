package com.uu.husky.spi.dubbo.service;

import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.common.utils.StringUtils;

/**
 * @author liuph
 * @desc
 * @date 2021/03/18 18:59
 */
@Adaptive
public class IAdaptiveComputerImpl implements IComputer{

    private static volatile String DEFAULT_COMPUTER;

    public static void setDefaultComputer(String defaultComputer) {
        DEFAULT_COMPUTER = defaultComputer;
    }

    @Override
    public void coding() {
        IComputer computer;
        ExtensionLoader<IComputer> loader = ExtensionLoader.getExtensionLoader(IComputer.class);
        String name = DEFAULT_COMPUTER;
        if(StringUtils.isNotEmpty(name)){
            computer = loader.getExtension(name);
        }else{
            computer = loader.getDefaultExtension();
        }
        computer.coding();
    }
}
