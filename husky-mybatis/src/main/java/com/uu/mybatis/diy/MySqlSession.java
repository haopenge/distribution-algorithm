package com.uu.mybatis.diy;


import java.lang.reflect.Proxy;

/**
 * @desc sqlSession 定义
 * @author liuph
 * @date  2019/08/11 15:15
 */
public class MySqlSession {
    private Executor executor = new SimpleExecutor();

    public <T> T selectOne(String statement, Object parameter) {
        return executor.query(statement,parameter);
    }

    public <T> T getMapper(Class<T> clazz) {
        MapperProxy mapperProxy = new MapperProxy(this, clazz);

        return (T) Proxy.newProxyInstance(clazz.getClassLoader(),
                new Class[]{clazz},mapperProxy );
    }
}
