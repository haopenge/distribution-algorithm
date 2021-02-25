package com.uu.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @desc 动态数据源
 * @author liuph
 * @date 2021/02/25 14:58
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSource();
    }
}
