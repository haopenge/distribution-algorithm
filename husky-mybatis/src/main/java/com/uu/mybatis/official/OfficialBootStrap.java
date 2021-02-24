package com.uu.mybatis.official;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @desc mybatis 连接正确姿势
 * @author liuph
 * @date 2019/08/11 15:55
 */
public class OfficialBootStrap {


    public static void main(String[] args) {
        SqlSession sqlSession = getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        PageHelper.startPage(2,2);
        List<User> userList = userDao.find();

        PageInfo<User> pageInfo = new PageInfo<User>(userList);

    }

    /**
     * @desc 获取连接会话
     * @author liuph
     * @date  2019/08/11 15:56
     * @return sqlSession
     */
    public static SqlSession getSqlSession() {
        InputStream inputStream = OfficialBootStrap.class.getResourceAsStream("/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        return sqlSessionFactory.openSession(true);
    }
}
