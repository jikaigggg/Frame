package com.jikaigg.dao;

import com.jikaigg.domain.Account;

public interface AccountDao {

    /**
     * 通过id查询账户信息
     * @param id
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 通过name查询账户信息
     * @param name
     * @return
     */
    Account findAccountByName(String name);

    /**
     * 更新账户信息
     * @param account
     */
    void updateAccount(Account account);

}
