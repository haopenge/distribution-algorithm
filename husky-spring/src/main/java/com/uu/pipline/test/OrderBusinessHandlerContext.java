package com.uu.pipline.test;

import com.uu.pipline.BusinessHandlerContext;

import java.util.List;

/**
 * @desc
 * @author liuph
 * @date 2021/04/02 17:55
 */
public class OrderBusinessHandlerContext implements BusinessHandlerContext {

    /**
     * 订单信息
     */
    private BaseOrderInfo baseOrderInfo;

    /**
     * 优惠信息
     */
    private List<PrivilegeInfo> privilegeInfoList;


}


