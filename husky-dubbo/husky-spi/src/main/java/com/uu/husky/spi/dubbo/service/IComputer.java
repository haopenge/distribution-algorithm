package com.uu.husky.spi.dubbo.service;

import org.apache.dubbo.common.extension.SPI;

/**
 * @desc
 * @author liuph
 * @date 2021/03/18 16:29
 */
@SPI("mac")
public interface IComputer {
    void coding();
}
