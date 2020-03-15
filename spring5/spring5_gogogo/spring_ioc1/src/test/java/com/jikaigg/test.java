package com.jikaigg;

import com.jikaigg.pojo.Hello;
import com.jikaigg.pojo.Student;
import com.jikaigg.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    @Test
    public void test1() {
        // 获取spring的上下文对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Hello hello = (Hello) ac.getBean("hello");
        System.out.println(hello);
    }
    @Test
    public void test2(){
        User user = new User();
    }

    @Test
    public void test3(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) ac.getBean("user");
        user.show();
    }

    @Test
    public void test4(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) ac.getBean("student");
        student.show();
    }

}
