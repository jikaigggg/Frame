package com.jikaigg.test;

import com.jikaigg.comfig.SpringConfigration;
import com.jikaigg.dao.UserDao;
import com.jikaigg.domain.Account;
import com.jikaigg.service.UserService;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

public class userServiceTest {

    @Test
    public void findAll() {
        ApplicationContext as = new AnnotationConfigApplicationContext(SpringConfigration.class);
        UserService service = as.getBean("userService",UserService.class);
        List<Account> accounts = service.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
    @Test
    public void findAccountById() {
        ApplicationContext as = new AnnotationConfigApplicationContext(SpringConfigration.class);
        UserService service = as.getBean("userService",UserService.class);
        Account account = service.findAccountById(2);
        System.out.println(account);
    }
    @Test
    public void insertAccount() {
        ApplicationContext as = new AnnotationConfigApplicationContext(SpringConfigration.class);
        UserService service = as.getBean("userService",UserService.class);
        Account account = new Account();
        account.setName("xinzhizhu");
        account.setMoney(10f);
        service.insertAccount(account);
    }

    @Test
    public void updateAccount() {
        ApplicationContext as = new AnnotationConfigApplicationContext(SpringConfigration.class);
        UserService service = as.getBean("userService",UserService.class);
        Account account = new Account();
        account.setId(4);
        account.setName("yeyuanxinzhizhu");
        account.setMoney(10.5f);
        service.updateAccount(account);
    }
    @Test
    public void deleteAccount(){
        ApplicationContext as = new AnnotationConfigApplicationContext(SpringConfigration.class);
        UserService service = as.getBean("userService", UserService.class);
        service.deleteAccount(4);
    }

    @Test
    public void accountScope(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfigration.class);
        QueryRunner runner1 = ac.getBean("runner", QueryRunner.class);
        QueryRunner runner2 = ac.getBean("runner", QueryRunner.class);
        System.out.println(runner1 == runner2);

    }
}
