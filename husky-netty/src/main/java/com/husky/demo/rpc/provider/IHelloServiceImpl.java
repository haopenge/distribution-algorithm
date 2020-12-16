package com.husky.demo.rpc.provider;

import com.husky.demo.rpc.api.IHelloService;

/**
 * @desc hello Imp
 * @author liuph
 * @date 2020/12/10 21:56
 */
public class IHelloServiceImpl implements IHelloService {
    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
