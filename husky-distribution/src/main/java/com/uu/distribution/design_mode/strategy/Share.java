package com.uu.distribution.design_mode.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc
 * @author liuph
 * @date 2020/05/09 10:24
 */
public class Share {
    private static List<DealContext> algs = new ArrayList();
    //静态代码块,先加载所有的策略
    static {
        algs.add(new DealContext("Sina",new DealSina()));
        algs.add(new DealContext("WeChat",new DealWeChat()));
    }
    public void shareOptions(String type){
        DealStrategy dealStrategy = null;
        for (DealContext deal : algs) {
            if (deal.options(type)) {
                dealStrategy = deal.getDeal();
                break;
            }
        }
        dealStrategy.dealMythod(type);
    }
}
