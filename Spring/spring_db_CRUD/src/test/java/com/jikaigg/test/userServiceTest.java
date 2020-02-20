package com.jikaigg.test;

import com.jikaigg.dao.UserDao;
import com.jikaigg.domain.Account;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class userServiceTest {

    public void findAll() {
        ClassPathXmlApplicationContext as = new ClassPathXmlApplicationContext("bean.xml");
        UserDao userdao = as.getBean("userDao", UserDao.class);
        List<Account> accounts = userdao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
