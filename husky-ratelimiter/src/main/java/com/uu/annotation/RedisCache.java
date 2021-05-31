package com.uu.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * redis 缓存
 * @author liuph
 * @date 2021/05/30 23:33
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisCache {

    /**
     *  key 前缀
     */
    String prefixKey() default "";

    /**
     *  key  参数映射值
     */
    String[] keys() default {};

    /**
     * 过期时间,单位秒
     */
    long expire() default 1;
}
