package com.jikaigg;

import com.jikaigg.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试aop配置
 */
public class aopTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService service = (AccountService) ac.getBean("accountService");
        service.saveAccount();
        // service.updateAccount(1);
        // service.deleteAccount();

    }
}
