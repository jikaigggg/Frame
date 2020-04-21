package com.jikaigg.shiro;

import com.jikaigg.shiro.entity.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ShiroApplicationTests {

    @Test
    void contextLoads() {



    }
    @Test
    public void test1(){
        Student s = new Student("Xiao Ming", 12, 89);
    }


    class Person {
        protected String name;
        protected int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public class Student extends Person {
        protected int score;

        public Student(String name, int age, int score) {
            super(name, age);
            this.score = score;
        }
    }

}
