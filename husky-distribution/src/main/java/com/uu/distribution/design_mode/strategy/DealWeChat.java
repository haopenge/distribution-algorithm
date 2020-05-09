package com.uu.distribution.design_mode.strategy;

/**
 * @desc
 * @author liuph
 * @date 2020/05/09 10:17
 */
public class DealWeChat implements DealStrategy{

    @Override
    public void dealMythod(String option){
        //...
        System.out.println("微信：" + option);
    }
}
