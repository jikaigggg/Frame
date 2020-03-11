package com.jikaigg.Mybatis.sqlsession;

import com.jikaigg.Mybatis.cfg.Configuration;
import com.jikaigg.Mybatis.sqlsession.impl.SqlSessionFactoryImpl;
import com.jikaigg.Mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 用于创建一个SqlSessionFactory对象
 */
public class SqlSessionFactoryBuilder {
    /**
     * 根据参数的字节输入流来构建一个SqlSessionFactory工厂
     * @param config
     * @return
     */
    public  SqlSessionFactory build(InputStream config){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new SqlSessionFactoryImpl(cfg);
    }
}
