package com.jikaigg.controller;

import com.jikaigg.domain.Account;
import com.jikaigg.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MybatiesController {
    @Autowired
    private AccountMapper accountMapper;


    @RequestMapping("query")
    public List<Account> queryAccountList(){
        List<Account> accounts = accountMapper.queryAccountList();
        return accounts;

    }
}
