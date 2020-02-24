package com.jikaigg;

import com.jikaigg.dao.AccountDao;
import com.jikaigg.dao.impl.AccountDaoImpl;
import com.jikaigg.domain.Account;
import com.jikaigg.service.AccountService;
import com.jikaigg.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    @Test
    public void test(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountServiceImpl accountService = (AccountServiceImpl) ac.getBean("accountService", AccountService.class);
        //AccountDaoImpl accountDao = (AccountDaoImpl) ac.getBean("accountDao", AccountDao.class);
        accountService.transfer("yaojikai","shimengyu",100f);
        // Account yaojikai = accountDao.findByName("yaojikai");
        // System.out.println(yaojikai);
    }
}
