package com.uu.pipline.test;

import com.uu.pipline.BusinessHandlerContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @desc  管道自定义环境变量
 * @author liuph
 * @date 2021/04/02 17:55
 */
public class OrderBusinessHandlerContext implements BusinessHandlerContext<Map> {

    /**
     * 订单信息
     */
    private BaseOrderInfo baseOrderInfo;

    /**
     * 优惠信息
     */
    private List<PrivilegeInfo> privilegeInfoList;

    /**
     * 定义返回结果
     */
    private Map<String, Object> resultMap;


    @Override
    public Map getResult() {
        return new HashMap();
    }

    @Override
    public void setResult(Map resultMap) {
        this.resultMap = resultMap;
    }
}


