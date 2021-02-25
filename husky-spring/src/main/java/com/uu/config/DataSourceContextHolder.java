package com.uu.config;

/**
 * @desc dataSouce Holder
 * @author liuph
 * @date 2021/02/25 15:02
 */
public class DataSourceContextHolder {
    private static final ThreadLocal<String> holder = new ThreadLocal<>();


    // 设置数据源名
    public static void setDataSource(String name) {
        holder.set(name);
    }

    // 获取数据源名
    public static String getDataSource() {
        return holder.get();
    }

    // 清除数据源名
    public static void removeDataSource() {
        holder.remove();
    }
}
