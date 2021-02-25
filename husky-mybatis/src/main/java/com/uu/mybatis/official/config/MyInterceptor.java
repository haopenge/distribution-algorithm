package com.uu.mybatis.official.config;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.util.List;
import java.util.Properties;

/**
 * @desc
 * @author liuph
 * @date 2021/02/25 10:07
 */
@Intercepts(
        {
                @Signature(type= StatementHandler.class,method="parameterize",args=java.sql.Statement.class),
                @Signature(type= StatementHandler.class,method="prepare",args={Connection.class, Integer.class})
        }

)
public class MyInterceptor implements Interceptor {
    /**
     * intercept:拦截
     * */
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("myfirstplugin...intercept："+invocation.getMethod());

        Object target = invocation.getTarget();
        StatementHandler statementHandler = (StatementHandler) target;

        BoundSql boundSql = statementHandler.getBoundSql();
        String sql = boundSql.getSql();

        Object parameterObject = boundSql.getParameterObject();
        List<ParameterMapping> parameterMappingList = boundSql.getParameterMappings();

        System.out.println("SQL：[" + sql + "]");
        System.out.println("param：[" + parameterObject + "]");

        if(invocation.getMethod().getName().equals("prepare")){
            MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
            //重新设置sql
            metaStatementHandler.setValue("delegate.boundSql.sql",sql + " limit  1");
        }
        return invocation.proceed();
    }

    // 包装目标对象，为目标对象创建一个代理对象
    public Object plugin(Object target) {
        System.out.println("-->myfirstplugin...plugin，将要包装的对象："+target);
        return Plugin.wrap(target, this);
    }

    //将插件注册时的property属性设置进来
    public void setProperties(Properties properties) {
        System.out.println("插件配置的信息："+properties);
    }

}
