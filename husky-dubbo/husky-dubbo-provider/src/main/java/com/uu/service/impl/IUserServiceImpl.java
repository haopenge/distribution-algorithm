package com.uu.service.impl;

import com.uu.service.IUserService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author liuph
 * @desc
 * @date 2021/03/22 15:25
 */
@DubboService(interfaceClass = IUserService.class)
public class IUserServiceImpl implements IUserService {
    @Override
    public String login(String username, String password) {
        return username + "_" + password;
    }
}
