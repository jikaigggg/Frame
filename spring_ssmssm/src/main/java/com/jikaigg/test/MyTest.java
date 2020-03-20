package com.jikaigg.test;

import com.jikaigg.mapper.UserMapper;
import com.jikaigg.pojo.User;
import com.jikaigg.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = ac.getBean("userServiceImpl", UserService.class);
        User user = userService.findByName("么济恺");
            System.out.println(user);

    }
}
