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
import java.util.ArrayList;
import java.util.List;

public class MybatisTest {
    private InputStream in;
    private AccountDao accountDao;

    /**
     * 初始化是执行
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
        accountDao = session.getMapper(AccountDao.class);

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
    public void testFindAll(){
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    /**
     * 查询所有账户，并且带有用户名称和地址信息
     */
    @Test
    public void testFindAllAccount(){
        List<AccountUser> accounts = accountDao.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

}
