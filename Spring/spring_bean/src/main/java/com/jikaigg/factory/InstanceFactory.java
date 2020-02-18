package com.jikaigg.factory;

import com.jikaigg.service.AccountService;
import com.jikaigg.service.impl.AccountServiceImpl;

public class InstanceFactory {
    public AccountService getAccountService(){
        return new AccountServiceImpl();
        }
    }

