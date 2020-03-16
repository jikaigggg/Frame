package com.jikaigg.test;

import com.jikaigg.mapper.EmployeeMapper;
import com.jikaigg.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

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

}
