package com.jikaigg.service;

import com.jikaigg.domain.Account;

import java.util.List;

public interface UserService {

    List<Account> findAll();

    Account findAccountById(Integer accountId);

    void deleteAccount(Integer accountId);

    void updateAccount(Account account);

    void insertAccount(Account account);
}
