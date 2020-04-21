package com.jikaigg;

import com.jikaigg.domain.Account;
import com.jikaigg.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = ac.getBean("accountService", AccountService.class);
        accountService.transfer("yaojikai", "shimengyu", 1f);
    }

}

