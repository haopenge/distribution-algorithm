package com.uu.pipline;

/**
 * @desc 业务 处理环境
 * @author liuph
 * @date 2021/04/02 15:07
 */
public interface BusinessHandlerContext<T> {

    T getResult();

    void setResult(T t);
}
