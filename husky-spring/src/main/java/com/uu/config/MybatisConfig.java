package com.uu.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @desc  mysql 动态数据源配置
 * @author liuph
 * @date 2021/02/25 15:03
 */
@Configuration
@MapperScan(basePackages = {"com.uu.dao"})
public class MybatisConfig {

    @Bean
    public DataSource readDs(){
        DruidDataSource ds = new DruidDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/ds1?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai");
        ds.setUsername("root");
        ds.setPassword("123456");
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        return ds;
    }

    @Bean
    public DataSource writeDs(){
        DruidDataSource ds = new DruidDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/ds0?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai");
        ds.setUsername("root");
        ds.setPassword("123456");
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        return ds;
    }

    @Bean
    public DynamicDataSource dynamicDataSource() throws SQLException {
        DynamicDataSource ds = new DynamicDataSource();
        Map<Object, Object> map = new HashMap<>();
        map.put("read",readDs());
        map.put("write",writeDs());

        ds.setTargetDataSources(map);
        ds.setDefaultTargetDataSource(writeDs());
        return ds;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws SQLException, IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        DefaultResourceLoader configLoader = new DefaultResourceLoader();
        sqlSessionFactoryBean.setConfigLocation(configLoader.getResource("classpath:mybatis/mybatis-config.xml"));

        ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resourceResolver.getResources("classpath:mybatis/mapper/*Mapper.xml");

        sqlSessionFactoryBean.setMapperLocations(resources);

        sqlSessionFactoryBean.setDataSource(dynamicDataSource());

        // 添加插件
        //sqlSessionFactoryBean.setPlugins(plugins);
        return sqlSessionFactoryBean;
    }

}
