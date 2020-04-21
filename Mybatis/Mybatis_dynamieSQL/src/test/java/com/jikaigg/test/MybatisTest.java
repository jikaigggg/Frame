package com.jikaigg.test;

import com.jikaigg.dao.UserDao;
import com.jikaigg.domain.QueryVo;
import com.jikaigg.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    private InputStream in;
    private UserDao userDao;

    /**
     * 初始化是执行
     *
     * @throws IOException
     */
    @Before //用于在测试方法执行之前执行
    public void init() throws IOException {
        // 1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");

        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);

        //3.使用代理对象创建dao对象
        SqlSession session = factory.openSession();
        userDao = session.getMapper(UserDao.class);

    }

    /**
     * 结束时执行
     */
    @After  //用于在测试方法执行之后执行
    public void destory() throws IOException {
        //提交事务

        //6.释放资源
        in.close();
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll() {

        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }


    /**
     * 测试根据id查询用户信息
     */
    @Test
    public void testFindById() {
        User user = userDao.findById(48);
        System.out.println(user);
    }

    /**
     * 测试根据username模糊查询用户信息
     */
    @Test
    public void testFindByName() {
        // 对应#{username}方式
        List<User> list = userDao.findByName("%二%");
        // 对应'%${value}%'方式
        // List<User> list = userDao.findByName("二");
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * 测试根据条件查询用户信息
     */
    @Test
    public void testFindByCondition() {
        User user = new User();
        user.setUsername("老王");
        List<User> users = userDao.findUserByCondition(user);
        for (User u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void findUserInIds() {
        QueryVo vo = new QueryVo();
        List<Integer> list = new ArrayList<Integer>();
        list.add(41);
        list.add(42);
        vo.setIds(list);
        List<User> users = userDao.findUserInIds(vo);

        for (User u : users) {
            System.out.println(u);
        }
    }

}
