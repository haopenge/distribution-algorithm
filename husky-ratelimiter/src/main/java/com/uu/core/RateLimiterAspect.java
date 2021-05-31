package com.uu.core;

import com.uu.annotation.RateLimiter;
import com.uu.exception.RateLimiterException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @desc redis 分布式限流
 * @author liuph
 * @date 2021/03/31 10:13
 */
@Aspect
@Component
public class RateLimiterAspect {
    private static final Logger logger = LoggerFactory.getLogger(RateLimiterAspect.class);

    @Autowired
    private RateLimiterService rateLimiterService;

    @Autowired
    private AbstractRedisService redisService;

    /**
     * 限流脚本Str
     */
    private String rateLimiterLuaStr;

    @PostConstruct
    public void init() {
        try (InputStream is = new ClassPathResource("META-INF/rateLimiter.lua").getInputStream()){
            rateLimiterLuaStr = StreamUtils.copyToString(is, StandardCharsets.UTF_8);
        } catch (IOException e) {
            logger.error("加载rateLimiter 限流脚本失败,",e);
        }
        logger.info("RateLimiterAspect --------> 脚本加载完成");
    }

    @Pointcut("@annotation(com.uu.annotation.RateLimiter)")
    public void rateLimiter() {}

    @Around("@annotation(rateLimiter)")
    public Object around(ProceedingJoinPoint joinPoint, RateLimiter rateLimiter) throws Throwable {
        long limit = rateLimiter.limit();
        long expire = rateLimiter.expire();
        boolean dynamic = rateLimiter.dynamic();
        String totalKey = rateLimiterService.getTotalKey(joinPoint, rateLimiter);

        if(dynamic){ // 如果是动态配置的话，从redis hash 中取
            Object limitObj = redisService.getHVal(rateLimiter.dynamicLimitKey(), totalKey);
            if(Objects.nonNull(limitObj)){
                limit = Integer.parseInt(limitObj.toString());
            }
        }

        if(limit <= 0 || expire < 0){ // 参数异常
            logger.error("RateLimiterAspect --------> 触发限流： limit:{} ,expire:{}",limit,expire);
            return joinPoint.proceed();
        }

        List<String> keyList = new ArrayList<>();
        keyList.add(totalKey);
        List<Long> result  = redisService.execLua(rateLimiterLuaStr, keyList, expire, limit);

        if ((!CollectionUtils.isEmpty(result)) && result.size() == 2) {
            String fallbackFunction = rateLimiter.fallbackFunction();
            // 获取失败回调方法
            if(StringUtils.hasText(fallbackFunction)){
                return rateLimiterService.executeFunction(fallbackFunction,joinPoint);
            }
            Long usedCountL = result.get(0);
            Long ttl = result.get(1);

            logger.info("RateLimiterAspect --------> 限流成功,限流key:{}, userCount:{},ttl:{}",totalKey,usedCountL,ttl);
            throw new RateLimiterException("RateLimiterAspect -------->  限流异常",ttl);
        }
        return joinPoint.proceed();
    }
}
