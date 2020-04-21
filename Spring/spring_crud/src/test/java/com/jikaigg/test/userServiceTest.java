package com.jikaigg.test;

import com.jikaigg.dao.UserDao;
import com.jikaigg.domain.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class userServiceTest {

    @Test
    public void findAll() {
        ClassPathXmlApplicationContext as = new ClassPathXmlApplicationContext("bean.xml");
        UserDao userdao = as.getBean("userDao", UserDao.class);
        List<Account> accounts = userdao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void findAccountById() {
        ClassPathXmlApplicationContext as = new ClassPathXmlApplicationContext("bean.xml");
        UserDao userdao = as.getBean("userDao", UserDao.class);
        Account account = userdao.findAccountById(2);
        System.out.println(account);
    }

    @Test
    public void insertAccount() {
        ClassPathXmlApplicationContext as = new ClassPathXmlApplicationContext("bean.xml");
        UserDao userdao = as.getBean("userDao", UserDao.class);
        Account account = new Account();
        account.setName("xinzhizhu");
        account.setMoney(10f);
        userdao.insertAccount(account);
    }

    @Test
    public void updateAccount() {
        ClassPathXmlApplicationContext as = new ClassPathXmlApplicationContext("bean.xml");
        UserDao userdao = as.getBean("userDao", UserDao.class);
        Account account = new Account();
        account.setId(4);
        account.setName("yeyuanxinzhizhu");
        account.setMoney(10.5f);
        userdao.updateAccount(account);
    }

    @Test
    public void deleteAccount() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        UserDao userDao = ac.getBean("userDao", UserDao.class);
        userDao.deleteAccount(4);
    }
}
