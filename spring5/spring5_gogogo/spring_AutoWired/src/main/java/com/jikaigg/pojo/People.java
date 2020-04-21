package com.jikaigg.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Data
public class People {
    private String name;

    //    @Autowired和@Qualifier组合使用，解决bean的id不一致造成的无法装配的问题
    @Autowired
    @Qualifier(value = "cat222")
    private Cat cat;
    @Autowired
    private Dog dog;


}
