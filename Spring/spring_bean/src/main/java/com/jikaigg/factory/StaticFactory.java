package com.jikaigg.factory;

import com.jikaigg.service.AccountService;
import com.jikaigg.service.impl.AccountServiceImpl;

public class StaticFactory {
    public static AccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
