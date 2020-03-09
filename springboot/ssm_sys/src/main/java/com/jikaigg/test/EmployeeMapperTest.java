package com.jikaigg.test;


import com.jikaigg.domain.Employee;
import com.jikaigg.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:springmvc.xml"})
public class EmployeeMapperTest {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Test
    public void testSelect(){
        Employee employee = employeeMapper.selectOneById(1);
        System.out.println(employee);
    }
}
