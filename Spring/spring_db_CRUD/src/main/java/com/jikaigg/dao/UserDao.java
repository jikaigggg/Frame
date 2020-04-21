package com.jikaigg.dao;

import com.jikaigg.domain.Account;

import java.util.List;

public interface UserDao {
    /**
     * 查询所有用户
     */
    List<Account> findAll();

    /**
     * 根据id查询用户信息
     *
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 删除用户
     *
     * @param accountId
     */
    void deleteAccount(Integer accountId);

    /**
     * 插入用户信息
     *
     * @param account
     */
    void insertAccount(Account account);

    /**
     * 更新用户信息
     *
     * @param account
     */
    void updateAccount(Account account);
}
