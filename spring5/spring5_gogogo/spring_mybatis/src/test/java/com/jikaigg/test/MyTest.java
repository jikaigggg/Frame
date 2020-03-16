package com.jikaigg.test;

import com.jikaigg.mapper.EmployeeMapper;
import com.jikaigg.mapper.impl.DeptMapperImpl;
import com.jikaigg.mapper.impl.EmployeeMapperImpl;
import com.jikaigg.pojo.Dept;
import com.jikaigg.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

public class MyTest {
    @Test
    public void test1() throws IOException {
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis.xml")).openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> all = mapper.findAll();
        for (Employee employee : all) {
            System.out.println(employee);
        }
    }

    @Test
    public void test2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeMapperImpl mapper = ac.getBean("employeeMapper", EmployeeMapperImpl.class);
        List<Employee> all = mapper.findAll();
        for (Employee employee : all) {
            System.out.println(employee);
        }
    }

    @Test
    public void test3() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        DeptMapperImpl mapper = ac.getBean("deptMapper", DeptMapperImpl.class);
        List<Dept> all = mapper.findAll();
        for (Dept dept : all) {
            System.out.println(dept);
        }
    }

}
