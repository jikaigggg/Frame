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

import javax.management.Query;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    private InputStream in;
    private SqlSession sqlSession;
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

        //3.使用工厂生产SqlSession对象
        sqlSession = factory.openSession();

        //4.使用SqlSession创建Dao接口的代理对象
        userDao = sqlSession.getMapper(UserDao.class);
    }
    /**
     * 结束时执行
     */
    @After  //用于在测试方法执行之后执行
    public void destory() throws IOException {
        //提交事务
        sqlSession.commit();

        //6.释放资源
        sqlSession.close();
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
        user.setUsername("yaojikaiinsert");
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
        user.setId(51);
        user.setUsername("yaojikaiyodate");
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
        userDao.deleteUser(51);

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
    /**
     * 测试使用QueryVo作为查询条件模糊查询用户信息
     */
    @Test
    public void testFindByQueryVo(){
        QueryVo qv = new QueryVo();
        User user = new User();
        user.setUsername("%二%");
        qv.setUser(user);
        // 对应#{username}方式
        List<User> list = userDao.findByQueryVo(qv);
        // 对应'%${value}%'方式
        // List<User> list = userDao.findByName("二");
        for (User u : list) {
            System.out.println(u);
        }
    }
}
