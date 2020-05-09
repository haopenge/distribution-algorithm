package com.uu.distribution.design_mode.strategy;

/**
 * @desc
 * @author liuph
 * @date 2020/05/09 10:17
 */
public class DealSina implements DealStrategy{

    @Override
    public void dealMythod(String option){
        //...
        System.out.println("新浪：" + option);
    }
}
