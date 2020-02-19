package com.jikaigg.dao.impl;

import com.jikaigg.dao.AccountDao;
import org.springframework.stereotype.Repository;

/**
 * 账户持久层实现类
 */
@Repository
public class AccountDaoImpl implements AccountDao {
    public void saveAccount() {
        System.out.println("保存成功");
    }
}
