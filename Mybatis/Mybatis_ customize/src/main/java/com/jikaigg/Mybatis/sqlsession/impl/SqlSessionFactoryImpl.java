package com.jikaigg.Mybatis.sqlsession.impl;

import com.jikaigg.Mybatis.cfg.Configuration;
import com.jikaigg.Mybatis.sqlsession.SqlSession;
import com.jikaigg.Mybatis.sqlsession.SqlSessionFactory;

/**
 * SqlSessionFactory接口的实现类
 */
public class SqlSessionFactoryImpl implements SqlSessionFactory {
    private Configuration cfg;
    public SqlSessionFactoryImpl(Configuration cfg){
        this.cfg = cfg;
    }
    /**
     * 用于创建一个新的操作数据库对象
     * @return
     */
    @Override
    public SqlSession openSession() {
        return new SqlSessionImpl(cfg);
    }
}
