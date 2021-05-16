package com.uu.mybatis.official.config;

import com.uu.mybatis.official.domain.ModifyModel;

/**
 * 审计handler
 * @author liuph
 * @date 2021/05/16 13:12
 */
public class AuditHolder {

    private static final ThreadLocal<ModifyModel> holder = new ThreadLocal<>();

    /**
     * 设置审计值
     * @author liuph
     * @date  2021/05/16 14:10
     */
    public static void set(ModifyModel modifyModel){
        holder.set(modifyModel);
    }

    /**
     * 获取审计值
     * @author liuph
     * @date  2021/05/16 14:11
     */
    public static ModifyModel getModifyModel() {
        return holder.get();
    }

    /**
     * 移除审计值
     */
    public static void removeModifyModel(){
        holder.remove();
    }
}
