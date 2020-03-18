package com.jikaigg.test;

import com.jikaigg.pojo.Books;
import com.jikaigg.service.BookService;
import com.jikaigg.service.impl.BookServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService serviceImpl = ac.getBean("bookServiceImpl", BookService.class);
        List<Books> all = serviceImpl.findAll();
        System.out.println(all);
    }
}
