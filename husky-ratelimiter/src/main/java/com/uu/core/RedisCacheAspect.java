package com.uu.core;

import com.alibaba.fastjson.JSONObject;
import com.uu.annotation.RedisCache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * redis 缓存切面
 * @author liuph
 * @date 2021/05/30 23:59
 */
@Aspect
@Component
public class RedisCacheAspect {
    @Autowired
    private AbstractRedisService redisService;

    @Autowired
    private RateLimiterParamProvider paramProvider;

    @Pointcut("@annotation(com.uu.annotation.RedisCache)")
    public void redisCache() {}

    @Around("@annotation(redisCache)")
    public Object around(ProceedingJoinPoint joinPoint, RedisCache redisCache) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Class clazz = signature.getReturnType();
        if(clazz == null){
            return joinPoint.proceed();
        }

        long expire = redisCache.expire();
        String prefixKey = redisCache.prefixKey();
        String[] keys = redisCache.keys();

        String customerKey = paramProvider.getCustomerKey(joinPoint, keys);
        String totalKey = prefixKey + customerKey;

        //缓存存入 与 获取
        String cacheDataStr = redisService.getVal(totalKey);
        if(cacheDataStr != null){
            return JSONObject.parseObject(cacheDataStr, clazz);
        }
        Object obj = joinPoint.proceed();
        redisService.setVal(totalKey,JSONObject.toJSONString(obj),expire);
        return obj;
    }

}
