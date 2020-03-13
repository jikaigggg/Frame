package com.jikaigg.test;

import com.jikaigg.dao.UserDao;
import com.jikaigg.dao.impl.UserDaoImpl;
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
import java.util.Date;
import java.util.List;

public class MybatisTest {
    private InputStream in;
    private UserDao userDao;

    /**
     * 初始化是执行
     * @throws IOException
     */
    @Before //用于在测试方法执行之前执行
    public void init() throws IOException {
        // 1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");

        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);

        //3.使用工厂对象创建dao对象
        userDao = new UserDaoImpl(factory);

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
    public void testFindAll(){

        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试保存用户
     */
    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("yaojikaidao");
        user.setAddress("北京");
        user.setSex("男");
        user.setBirthday(new Date());

        System.out.println("before   "+user);
        //5.执行保存方法
        userDao.saveUser(user);
        System.out.println("after    "+user);
    }

    /**
     * 测试更新用户信息
     */
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(53);
        user.setUsername("yaojikaiyodate1");
        user.setAddress("北京");
        user.setSex("男");
        user.setBirthday(new Date());

        //5.执行保存方法
        userDao.updateUser(user);

    }

    /**
     * 测试删除用户
     */
    @Test
    public void testDelete(){
        //5.执行保存方法
        userDao.deleteUser(53);

    }

    /**
     * 测试根据id查询用户信息
     */
    @Test
    public void testFindById(){
        User user = userDao.findById(48);
        System.out.println(user);
    }
    /**
     * 测试根据username模糊查询用户信息
     */
    @Test
    public void testFindByName(){
        // 对应#{username}方式
        List<User> list = userDao.findByName("%二%");
        // 对应'%${value}%'方式
        // List<User> list = userDao.findByName("二");
        for (User user : list) {
            System.out.println(user);
        }
    }

}
