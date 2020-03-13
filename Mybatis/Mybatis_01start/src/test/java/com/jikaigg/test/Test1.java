package com.jikaigg.test;

import com.jikaigg.domain.User;
import com.jikaigg.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.InputStream;

public class Test1 {
    static Logger logger = Logger.getLogger(Test1.class);

    @Test
    public void test1() throws Exception {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User i = mapper.selectOne(1);
        System.out.println(i);
    }

    @Test
    public void testLog(){
        logger.info("yaojikai");
    }

}
