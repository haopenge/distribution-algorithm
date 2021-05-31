package com.uu.core;

import java.util.List;

/**
 * 抽象 redis 服务
 * @author liuph
 * @date 2021/05/30 17:01
 */
public interface AbstractRedisService {

    /**
     * 获取hash key
     * @param key  hash key
     * @param innerKey hash key innerKey
     * @return str
     */
    String getHVal(String key,String innerKey);


    /**
     * 执行lua 脚本
     * @param luaStr lua脚本字符串
     * @param keys  作用的Key
     * @param luaArgs lua 脚本参数
     * @return 返回值
     */
    List<Long> execLua(String luaStr, List<String> keys,Object... luaArgs);

    /**
     * 获取值
     * @param key key
     * @return val
     */
    String getVal(String key);


    /**
     * string 类型 设置值
     * @param key key
     * @param value value
     * @param expire 失效时间 单位s
     */
    void setVal(String key, String value,long expire);
}
