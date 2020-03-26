package com.jikaigg.springbootstart.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component
@Data
//@ConfigurationProperties(prefix = "dog")
public class Dog {
    private String name;
    private Integer age;
}
