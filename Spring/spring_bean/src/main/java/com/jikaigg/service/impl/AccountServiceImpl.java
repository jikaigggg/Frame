package com.jikaigg.service.impl;

import com.jikaigg.service.AccountService;

/**
 * 账户业务层实现类
 */
public class AccountServiceImpl implements AccountService {

    public void saveAccount() {
        System.out.println("service方法中的saveAccount");
    }

    public void init() {
        System.out.println("init...");
    }

    public void destory() {
        System.out.println("destoey...");
    }
}
