package com.uu.pipline;

/**
 * @desc 业务管道流
 * @author liuph
 * @date 2021/04/02 15:04
 */
public interface BusinessPipeline<T> {
    /**
     * 启动
     */
    void start();

    void addFirst(BusinessHandler... handlers);

    void addLast(BusinessHandler... handlers);

}
