package com.jikaigg.dao;

import com.jikaigg.domain.Account;

public interface AccountDao {
    Account findByName(String name);

    void updateAccount(Account account);
}
