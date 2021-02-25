package com.uu.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * @desc 数据源 代理
 * @author liuph
 * @date 2021/02/25 16:22
 */
@Aspect
public class DataSourceAspect {
    public DataSourceAspect() {
    }

    @Pointcut("@annotation(com.uu.config.DataSourceRouter)")
    public void annotationPointCut() {
    }

    @Before("annotationPointCut()")
    public void switchDataSource(JoinPoint point) {
        Class<?>[] classArr = point.getTarget().getClass().getInterfaces();
        String methodName = point.getSignature().getName();
        Class[] argsClass = ((MethodSignature)point.getSignature()).getMethod().getParameterTypes();

        try {
            Method method = classArr[0].getMethod(methodName, argsClass);
            if (method.isAnnotationPresent(DataSourceRouter.class)) {
                String dataSource = ((DataSourceRouter)method.getAnnotation(DataSourceRouter.class)).value();
                DataSourceContextHolder.setDataSource(dataSource);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    @After("annotationPointCut()")
    @AfterThrowing("annotationPointCut()")
    public void releaseDataSource() {
        DataSourceContextHolder.removeDataSource();
    }

}
