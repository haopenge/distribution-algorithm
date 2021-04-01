package com.uu.core;

import com.uu.annotation.RateLimiter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * rateLimiter 参数获取，异常方法处理
 */
@Component
public class RateLimiterService {
    private static final Logger logger = LoggerFactory.getLogger(RateLimiterService.class);

    @Autowired
    private RateLimiterParamProvider paramProvider;

    public String getTotalKey(JoinPoint joinPoint, RateLimiter rateLimit) {
        // 获取自定义字符串
        String businessKeyName = paramProvider.getCustomerKey(joinPoint, rateLimit);
        return rateLimit.prefixKey() + businessKeyName;
    }

    /**
     * 执行自定义函数
     */
    public Object executeFunction(String fallbackName, JoinPoint joinPoint) throws Throwable {
        Method currentMethod = ((MethodSignature) joinPoint.getSignature()).getMethod();
        Object target = joinPoint.getTarget();
        Method handleMethod = null;
        try {
            handleMethod = joinPoint.getTarget().getClass().getDeclaredMethod(fallbackName, currentMethod.getParameterTypes());
            handleMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            logger.error("RateLimiterHandler --------> 执行降级方法异常",e);
            throw new IllegalArgumentException("RateLimiterHandler --------> 执行降级方法异常", e);
        }

        Object[] args = joinPoint.getArgs();
        return handleMethod.invoke(target, args);
    }

}
