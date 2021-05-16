package com.uu.mybatis.official.config;

import com.uu.mybatis.official.domain.ModifyModel;
import com.uu.mybatis.official.util.ModelHelper;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Properties;

/**
 * @author liuph
 * @desc 自定义sql 增强拦截器
 * @date 2021/02/25 10:07
 */
@Intercepts(
        {
                @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})
        }
)
public class AuditInterceptor implements Interceptor {
    /**
     * intercept:拦截
     */
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement) args[0];
        Object obj = args[1];

        SqlCommandType sqlCommandType = ms.getSqlCommandType();
        boolean isInsert = false;
        switch (sqlCommandType) {
            case INSERT:
                isInsert = true;
            case UPDATE:
                if (obj instanceof List) {  // 批量插入处理
                    List<Object> innerObj = (List<Object>) obj;
                    boolean finalIsInsert = isInsert;
                    innerObj.forEach(loopObj -> {
                        // 新增属性
                        ModifyModel modifyModel = AuditHolder.getModifyModel();
                        if (finalIsInsert) {
                            ModelHelper.buildCreateAndModify(obj, modifyModel);
                        } else {
                            ModelHelper.buildModify(obj, modifyModel);
                        }
                    });
                } else { // 新增属性
                    ModifyModel modifyModel = AuditHolder.getModifyModel();
                    if (isInsert) {
                        ModelHelper.buildCreateAndModify(obj, modifyModel);
                    } else {
                        ModelHelper.buildModify(obj, modifyModel);
                    }

                }
                Method method = invocation.getMethod();
                return method.invoke(invocation.getTarget(), args);

        }
        return invocation.proceed();
    }

    /**
     * 包装目标对象，为目标对象创建一个代理对象
     *
     * @param target 目标对象
     * @author liuph
     * @date 2021/05/16 13:11
     */
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    /**
     * 拦截器自定义属性
     *
     * @author liuph
     * @date 2021/05/16 13:11
     */
    public void setProperties(Properties properties) {
    }

}
