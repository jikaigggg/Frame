package com.jikaigg.dao;

import com.jikaigg.domain.Account;

import java.util.List;

/**
 * 账户的持久层接口
 */
public interface AccountDao {

    /**
     * 查询所有
     *
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     *
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 根据名称查询账户
     *
     * @param accountName
     * @return 如果有位移的一个结果就返回，如果没有结果就返回null
     * 如果结果集超过一个就抛异常
     */
    Account findAccountByName(String accountName);

    /**
     * 保存
     *
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新
     *
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     *
     * @param acccountId
     */
    void deleteAccount(Integer acccountId);
}
