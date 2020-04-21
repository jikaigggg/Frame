package com.jikaigg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * 和事务相关的配置类
 */
public class TransectionConfig {
    /**
     * 用于创建事务管理器对象
     *
     * @param dataSource
     * @return
     */
    @Bean("tansectionManager")
    public PlatformTransactionManager createTransectionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
