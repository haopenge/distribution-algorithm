package com.uu.pipline;

/**
 * @desc 业务处理器
 * @author liuph
 * @date 2021/04/02 15:22
 */
public interface BusinessHandler {

    /**
     * 是否异步执行
     */
    default boolean async(){
        return false;
    }

    /**
     * 执行具体业务
     */
    boolean handler(BusinessHandlerContext context);

}
