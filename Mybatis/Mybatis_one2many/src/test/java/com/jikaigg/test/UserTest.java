package com.jikaigg.test;

import com.jikaigg.dao.AccountDao;
import com.jikaigg.dao.UserDao;
import com.jikaigg.domain.Account;
import com.jikaigg.domain.AccountUser;
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
        SqlSessionFactory factory = builder.build(in);

        //3.使用代理对象创建dao对象
        SqlSession session = factory.openSession();
        userDao = session.getMapper(UserDao.class);

    }

    /**
     * 结束时执行
     */
    @After  //用于在测试方法执行之后执行
    public void destory() throws IOException {
        //提交事务

        //6.释放资源
        in.close();
    }

    /**
     * 测试查询所有,同时获取到当前账户的所属账户信息
     */
    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
            for (Account account : user.getAccounts()) {
                System.out.println(account);
            }
        }
    }


}
