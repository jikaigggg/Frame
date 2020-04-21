package com.jikaigg.service;

import com.jikaigg.domain.Account;

/**
 * 账户业务层接口
 */
public interface AccountService {
    /**
     * 通过id查询账户信息
     *
     * @param id
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 通过name查询账户信息
     *
     * @param name
     * @return
     */
    Account findAccountByName(String name);

    /**
     * 转账
     *
     * @param sourceName
     * @param targetName
     * @param money
     */
    void transfer(String sourceName, String targetName, Float money);
}
