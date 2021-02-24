package com.uu.mybatis.diy;

public interface Executor {
    <E> E query(String statement, Object parameter);
}