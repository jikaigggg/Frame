package com.jikaigg.service;

/**
 * 账户业务层接口
 * 曾经XML的配置：<bean id="accountService" class="com.jikaigg.service.impl.AccountServiceImpl"></bean>
 */
public interface AccountService {
    /**
     * 模拟保存账户
     */

    void saveAccount();
}
