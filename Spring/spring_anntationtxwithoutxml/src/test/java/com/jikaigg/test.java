package com.jikaigg;

import com.jikaigg.config.SpringConfiguration;
import com.jikaigg.domain.Account;
import com.jikaigg.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class test {
    @Autowired
    private AccountService as;

    @Test
    public void test() {
        as.transfer("yaojikai", "shimengyu", 3f);
    }


}

