package com.jikaigg.ui;

import com.jikaigg.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Client {
    /**
     * 获取spring的Ioc核心容器对象，并根据id获取对象
     *
     */
    public static void main(String[] args) {
        //第一种加载方式
        //1.获取核心容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        //2.根据id获取bean对象
        AccountService as1 = (AccountService) ac.getBean("accountService1");
        AccountService as2 = (AccountService) ac.getBean("accountService2");
        AccountService as3 = (AccountService) ac.getBean("accountService3");
        as3.saveAccount();

    }
}















