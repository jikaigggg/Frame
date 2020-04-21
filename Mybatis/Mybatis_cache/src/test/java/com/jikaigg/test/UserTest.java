package com.jikaigg.test;

import com.jikaigg.dao.UserDao;
import com.jikaigg.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private UserDao userDao;

    /**
     * 初始化是执行
     *
     * @throws IOException
     */
    @Before //用于在测试方法执行之前执行
    public void init() throws IOException {
        // 1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");

        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);

        //3.使用代理对象创建dao对象
        session = factory.openSession();
        userDao = session.getMapper(UserDao.class);

    }

    /**
     * 结束时执行
     */
    @After  //用于在测试方法执行之后执行
    public void destory() throws IOException {
        //提交事务

        //6.释放资源
        session.close();
        in.close();
    }

    /**
     * 测试以及缓存
     */
    @Test
    public void testFirstLevelCache() {
        User user1 = userDao.findById(41);
        System.out.println(user1);
/*        session.close();
        session = factory.openSession();
        userDao = session.getMapper(UserDao.class);*/
        session.clearCache();
        User user2 = userDao.findById(41);
        System.out.println(user2);
        System.out.println(user1 == user2);
    }

    @Test
    public void testFirstClearCache() {
        User user1 = userDao.findById(52);
        System.out.println(user1);
        //更新用户信息
        user1.setUsername("yyy");
        userDao.updateUser(user1);

        User user2 = userDao.findById(52);
        System.out.println(user2);
        System.out.println(user1 == user2);
    }
}
