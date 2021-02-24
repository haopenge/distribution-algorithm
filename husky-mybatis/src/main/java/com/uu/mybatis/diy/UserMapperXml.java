package com.uu.mybatis.diy;


import java.util.HashMap;
import java.util.Map;

public class UserMapperXml {
    public static final String nameSpace = "com.uu.mybatis.diy.UserMapper";

    public static final Map<String, String> methodSqlMapping = new HashMap();

    static {
        methodSqlMapping.put("selectByPrimaryKey", "select * from user where id = %d");
    }
}