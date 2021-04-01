package com.uu.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @desc 限流注解
 * @author liuph
 * @date 2021/03/31 09:50
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RateLimiter {

    /**
     * 限流 key 前缀
     */
    String prefixKey() default "rate-limiter";

    /**
     *  限流key  参数映射值
     */
    String[] keys() default {};

    /**
     * 限制数量
     */
    long limit() default 0;

    /**
     * limit 值是否是动态的，默认从：redis中获取：hash  rate_limiter_dynamic: key :value
     */
    boolean dynamic() default false;

    /**
     * limit 动态时,获取 limit 的 key 的值
     */
    String dynamicLimitKey() default "rate_limiter_dynamic";

    /**
     * 过期时间,单位秒
     */
    long expire() default 1;

    /**
     * 失败回调方法： 调用类的  同类方法（必须保证参数相同）
     */
    String fallbackFunction() default "";
}
