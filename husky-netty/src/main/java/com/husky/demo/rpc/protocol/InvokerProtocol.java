package com.husky.demo.rpc.protocol;

import lombok.Data;

import java.io.Serializable;

/**
 * @desc 自定义传输协议
 * @author liuph
 * @date 2020/12/10 22:40
 */
@Data
public class InvokerProtocol implements Serializable {

    /**
     * 类名
     */
    private String className;

    /**
     * 函数名称
     */
    private String methodName;

    /**
     * 形参列表
     */
    private Class<?>[] parameters;

    /**
     * 实参列表
     */
    private Object[] values;
}
