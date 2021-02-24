package com.uu.mybatis.diy;


/**
 * @author liuph
 * @date 2019/08/11 02:32
 */
public class BootStrap {
    public static void start(){
        MySqlSession sqlSession = new MySqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectByPrimaryKey(1);

        System.out.println(user);
    }

    public static void main(String[] args) {
        start();
    }
}