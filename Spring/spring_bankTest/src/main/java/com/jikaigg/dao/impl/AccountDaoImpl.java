package com.jikaigg.dao.impl;

import com.jikaigg.dao.AccountDao;
import com.jikaigg.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AccountDaoImpl implements AccountDao {
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
         this.jdbcTemplate = jdbcTemplate;
    }

    public Account findByName(String name) {
        List<Account> accounts = jdbcTemplate.query("select * from account where name = ?",new BeanPropertyRowMapper<Account>(Account.class),name);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set money=? where id=?",account.getMoney(),account.getId());
    }
}
