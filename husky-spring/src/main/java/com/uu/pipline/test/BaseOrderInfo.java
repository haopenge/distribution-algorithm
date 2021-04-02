package com.uu.pipline.test;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author liuph
 */
@Setter
@Getter
public class BaseOrderInfo {

    private Integer userId;

    /**
     * 优惠码
     */
    private String discountCode;

    private Integer addressId;

    /**
     * 下单类型，0-直接下单  1-购物车下单
     */
    private Integer type;

    /**
     * 商品id
     */
    private Integer skuId;

    /**
     * 购物车 id
     */
    private List<Integer> cartId;

    /**
     * 支付方式
     */
    private Integer payType;



}
