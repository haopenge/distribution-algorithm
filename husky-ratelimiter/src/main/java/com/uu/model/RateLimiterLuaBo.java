package com.uu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @desc rateLimit 信息
 * @author liuph
 * @date 2021/04/01 14:50
 */
@Setter
@Getter
@AllArgsConstructor
public class RateLimiterLuaBo {
    /**
     * 限流key
     */
    private String key;

    /**
     * 限制次数
     */
    private long limit;

    /**
     * 限制持续时间
     */
    private long expire;

}
