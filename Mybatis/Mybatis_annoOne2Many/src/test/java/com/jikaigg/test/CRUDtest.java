package com.jikaigg.test;

import com.jikaigg.dao.UserDao;
import com.jikaigg.domain.User;
import jdk.nashorn.internal.ir.CallNode;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSessionManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.rmi.server.ExportException;
import java.util.Date;
import java.util.List;

public class CRUDtest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private UserDao userdao;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
        userdao = sqlSession.getMapper(UserDao.class);
    }

    @After
    public void destory() throws Exception {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    /**
     * 根据id查询用户信息
     *
     * @throws Exception
     */
    @Test
    public void findByIdTest() {
        User user = userdao.findById(52);
        System.out.println(user);
    }

    /**
     * 根据用户名模糊查询用户信息
     */
    @Test
    public void findUserByNameTest() {
        List<User> users = userdao.findUserByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 保存用户
     */
    @Test
    public void insertTest() {
        User user1 = new User();
        user1.setUsername("jjj");
        user1.setAddress("南京市");
        user1.setSex("女");
        user1.setBirthday(new Date());
        //userdao.saveUser(user1);
    }

    /**
     * 更新用户
     */
    @Test
    public void updateTest() {
        User user1 = new User();
        user1.setId(55);
        user1.setUsername("kkk");
        user1.setAddress("胸径市");
        user1.setSex("男");
        user1.setBirthday(new Date());
        //userdao.updateUser(user1);
    }

    /**
     * 删除用户
     */
    @Test
    public void deleteTest() {
        //userdao.deleteUser(55);
    }
}
