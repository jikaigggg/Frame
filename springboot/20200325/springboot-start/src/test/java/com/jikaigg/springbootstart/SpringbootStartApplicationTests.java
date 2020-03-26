package com.jikaigg.springbootstart;

import com.jikaigg.springbootstart.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
//@EnableConfigurationProperties(Person.class)
class SpringbootStartApplicationTests {

    @Autowired
    private Person person;
    @Test
    void contextLoads() {
        System.out.println(UUID.randomUUID().toString().replace("-",""));
        System.out.println(person);
    }

}
