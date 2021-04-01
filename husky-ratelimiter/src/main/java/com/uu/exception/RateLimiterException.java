package com.uu.exception;

/**
 * @desc 限流后抛出异常
 * @author liuph
 * @date 2021/03/31 16:07
 */
public class RateLimiterException extends Exception{

    private long retryAfter;

    public RateLimiterException(String message,long retryAfter){
        super(message);
        this.retryAfter = retryAfter;
    }

}
