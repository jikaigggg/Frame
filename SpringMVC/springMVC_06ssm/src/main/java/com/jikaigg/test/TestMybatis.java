package com.jikaigg.test;

import com.jikaigg.dao.AccountDao;
import com.jikaigg.doamin.Account;
import com.jikaigg.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    /**
     * 测试查询
     *
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        //获取到代理对象
        AccountDao accountDao = session.getMapper(AccountDao.class);
        //查询所有账户信息
        List<Account> all = accountDao.findAll();
        for (Account account : all) {
            System.out.println(account);
        }

        //关闭资源
        session.close();
        in.close();
    }

    /**
     * 测试保存
     *
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        //获取到代理对象
        AccountDao accountDao = session.getMapper(AccountDao.class);

        Account account = new Account();
        account.setName("liudehua");
        account.setMoney(300d);
        //查询所有账户信息
        accountDao.saveAccount(account);

        //提交事务
        session.commit();

        //关闭资源
        session.close();
        in.close();
    }
}
