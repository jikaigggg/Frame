package com.jikaigg.blog;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class BlogApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;


    @Test
    void contextLoads() {
        Class<? extends JdbcTemplate> jdbcTemplateClass = jdbcTemplate.getClass();
        System.out.println(jdbcTemplateClass);
    }

}
