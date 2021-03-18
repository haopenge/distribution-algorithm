package com.uu.husky.spi.dubbo.service;

import org.apache.dubbo.common.extension.Activate;

/**
 * @author liuph
 * @desc
 * @date 2021/03/18 19:16
 */
@Activate(group = "c++")
public class ILinuxComputerImpl implements IComputer{
    @Override
    public void coding() {
        System.out.println(" mac  computer coding ....");
    }
}
