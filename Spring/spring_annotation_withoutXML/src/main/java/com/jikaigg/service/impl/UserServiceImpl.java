package com.jikaigg.service.impl;

import com.jikaigg.dao.UserDao;
import com.jikaigg.domain.Account;
import com.jikaigg.service.UserService;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    public List<Account> findAll() {
        return userDao.findAll();
    }

    public Account findAccountById(Integer accountId) {
        return userDao.findAccountById(accountId);
    }

    public void deleteAccount(Integer accountId) {
        userDao.deleteAccount(accountId);
    }

    public void updateAccount(Account account) {
        userDao.updateAccount(account);
    }

    public void insertAccount(Account account) {
        userDao.insertAccount(account);
    }
}
