package com.uu.mybatis.diy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MapperProxy<T> implements InvocationHandler {
    private final MySqlSession sqlSession;
    private final Class<T> mapperInterface;

    public MapperProxy(MySqlSession sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    public Object invoke(Object proxy, Method method, Object[] args){
        if (method.getDeclaringClass().getName().equals(UserMapperXml.nameSpace)) {
            String sql = UserMapperXml.methodSqlMapping.get(method.getName());

            System.out.println(String.format("SQL [ %s ], parameter [%s] ", sql, args[0]));
            return sqlSession.selectOne(sql, String.valueOf(args[0]));
        }
        return null;
    }
}