package com.jikaigg.service.impl;

import com.jikaigg.service.AccountService;

import java.util.Date;

/**
 * 账户业务层实现类
 */
public class AccountServiceImpl1 implements AccountService {
    private String name;
    private Integer age;
    private Date birthday;
    public AccountServiceImpl1(String name, Integer age, Date birthday){
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }
    public void saveAccount() {
        System.out.println("service方法中的saveAccount"+"---"+name+"---"+age+"---"+birthday);
    }

}
