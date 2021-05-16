package com.uu.mybatis.official;
import com.uu.mybatis.official.config.AuditHolder;
import com.uu.mybatis.official.domain.ModifyModel;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.Date;

/**
 * @desc mybatis 连接正确姿势
 * @author liuph
 * @date 2019/08/11 15:55
 */
public class OfficialBootStrap {


    public static void main(String[] args) {
        SqlSession sqlSession = getSqlSession();

        UserDao userDao = getById(sqlSession);

      /*  PageHelper.startPage(2,2);
        List<User> userList = userDao.find();

        PageInfo<User> pageInfo = new PageInfo<User>(userList);*/

        // List<User> userList = userDao.find();
        AuditHolder.set(new ModifyModel("sys"));
        insert(userDao);

        //  update(userDao);


    }

    private static UserDao getById(SqlSession sqlSession) {
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User getUser = userDao.findById(10);
        return userDao;
    }

    private static void update(UserDao userDao) {
        User user = new User();
        user.setPhone("16601114926");
        user.setRemark("VIP-update");
        user.setId(18);
        //  user.setUpdateTime(LocalDateTime.now());

        Integer insert = userDao.update(user);
    }

    private static void insert(UserDao userDao) {
        User user = new User();
        user.setPhone("16601114926");
        user.setRemark("VIP");
        user.setCreateTime(new Date());
        //  user.setUpdateTime(LocalDateTime.now());

        Integer insert = userDao.insert(user);
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
