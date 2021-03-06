package com.jikaigg.service.impl;

import com.jikaigg.dao.AccountDao;
import com.jikaigg.domain.Account;
import com.jikaigg.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    @Autowired
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    public Account findAccountByName(String name) {
        return accountDao.findAccountByName(name);
    }

    public void transfer(String sourceName, String targetName, Float money) {
        Account source = accountDao.findAccountByName(sourceName);
        Account target = accountDao.findAccountByName(targetName);
        source.setMoney(source.getMoney() - money);
        // int i = 1/0;
        target.setMoney(target.getMoney() + money);
        accountDao.updateAccount(source);
        accountDao.updateAccount(target);

    }
}
