package com.jikaigg.test;

import com.jikaigg.domain.User;
import com.jikaigg.mapper.UserMapper;
import com.sun.deploy.util.StringUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Test1 {
    static Logger logger = Logger.getLogger(Test1.class);

    @Test
    public void test1() throws Exception {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("id","1");
        map.put("name","yaojikai");
        map.put("email","yaojikai@gmail.com");
//        map.put("gender","男");
        map.put("departmentId","2");
        int i = mapper.updateOne(map);

    }

    @Test
    public void testLog() throws Exception{
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectOne(1);
        System.out.println(user);

        logger.info("yaojikai");
    }

    @Test
    public void test3(){
        String uuid = UUID.randomUUID().toString();
        String UUID = uuid.replace("-","");
        System.out.println(uuid+"\n"+UUID);
    }

    @Test
    public void test4() throws Exception{
        UserMapper mapper = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml")).openSession(true).getMapper(UserMapper.class);
        User user = new User();
        user.setEmp_name("shimengyu");
        user.setEmp_email("shimengyu@gmail.com");
        user.setGender("女");
        user.setDepartment_id("2");
        mapper.insertOne(user);

    }


    @Test
    public void test5() throws Exception {
        UserMapper mapper = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml")).openSession(true).getMapper(UserMapper.class);
        HashMap aaa = new HashMap();
        ArrayList<Integer> bbb = new ArrayList<Integer>();
        bbb.add(1);
        bbb.add(3);
        aaa.put("ids",bbb);
        List<User> users = mapper.selectIn(aaa);
        for (User user : users) {
            System.out.println(user);
        }

    }

}
