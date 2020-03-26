package com.jikaigg.springbootstart.config;

import com.jikaigg.springbootstart.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloService {
    @Bean
    public Person personService(){
        return new Person();
    }
}
