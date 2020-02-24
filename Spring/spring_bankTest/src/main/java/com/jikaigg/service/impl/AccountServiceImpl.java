package com.jikaigg.service.impl;

import com.jikaigg.dao.AccountDao;
import com.jikaigg.dao.impl.AccountDaoImpl;
import com.jikaigg.domain.Account;
import com.jikaigg.service.AccountService;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDaoImpl accountDao) {
        this.accountDao = accountDao;
    }

    public void transfer(String huaqian, String shouqian, Float money) {
        Account hua = accountDao.findByName(huaqian);
        Account shou = accountDao.findByName(shouqian);
        hua.setMoney(hua.getMoney()-money);
        shou.setMoney(shou.getMoney()+money);
        accountDao.updateAccount(hua);
        accountDao.updateAccount(shou);
    }
}
