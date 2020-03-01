package com.jikaigg.test;

import com.jikaigg.doamin.Account;
import com.jikaigg.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestSpring {
    @Test
    public void test1(){
        //加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        AccountService service = (AccountService) ac.getBean("accountService");
        service.findAll();

    }
}
