package com.jikaigg.service.impl;

import com.jikaigg.dao.AccountDao;
import com.jikaigg.service.AccountService;

/**
 * 账户业务层实现类
 */
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
