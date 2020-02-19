package com.jikaigg.service.impl;

import com.jikaigg.service.AccountService;

import java.util.Date;

/**
 * 账户业务层实现类
 */
public class AccountServiceImpl2 implements AccountService {
    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("service方法中的saveAccount"+"---"+name+"---"+age+"---"+birthday);
    }

}
