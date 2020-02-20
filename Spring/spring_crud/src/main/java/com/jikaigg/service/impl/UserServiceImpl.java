package com.jikaigg.service.impl;

import com.jikaigg.dao.UserDao;
import com.jikaigg.domain.Account;
import com.jikaigg.service.UserService;
import org.apache.commons.dbutils.QueryRunner;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

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
