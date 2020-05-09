package com.uu.distribution.design_mode.strategy;

/**
 * @desc
 * @author liuph
 * @date 2020/05/09 10:21
 */
public class DealContext {
    private String type;
    private DealStrategy deal;
    public  DealContext(String type,DealStrategy deal){
        this.type = type;
        this.deal = deal;
    }
    public DealStrategy getDeal(){
        return deal;
    }
    public boolean options(String type){
        return this.type.equals(type);
    }
}
