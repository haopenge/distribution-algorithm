package com.uu.pipline.test;

import lombok.Getter;
import lombok.Setter;

/**
 * @desc 优惠信息
 * @author liuph
 * @date 2021/04/02 18:48
 */
@Setter
@Getter
public class PrivilegeInfo {
    /**
     * 优惠名称
     */
    private String name;

    /**
     * 扣减金额
     */
    private Integer removeMoney;

}
