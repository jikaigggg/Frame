package com.jikaigg.test;

import com.jikaigg.dao.AccountDao;
import com.jikaigg.domain.Account;
import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;
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

public class AccountTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private AccountDao accountDao;
    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
        accountDao = sqlSession.getMapper(AccountDao.class);
    }
    @After
    public void destory() throws IOException {
        sqlSession.close();
        in.close();
    }

    @Test
    public void findAllTest(){
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

}
