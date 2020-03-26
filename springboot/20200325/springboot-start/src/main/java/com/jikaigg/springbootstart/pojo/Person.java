package com.jikaigg.springbootstart.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

//@Component
@Data
@ConfigurationProperties(prefix = "person")
public class Person {
    private String name;
    @Value("${person.age:15}")
    private Integer age;
    private Boolean happy;
    private List<String> list;
    private Map<String,String> map;
    private Set<String> set;
    private Dog dog;
}
