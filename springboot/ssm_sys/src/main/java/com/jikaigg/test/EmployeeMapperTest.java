package com.jikaigg.test;


import com.jikaigg.domain.Employee;
import com.jikaigg.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:springmvc.xml"})
public class EmployeeMapperTest {
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 测试根据id查询员工信息
     */
    @Test
    public void testSelectOneById() {
        Employee employee = employeeMapper.selectOneById(2);
        System.out.println(employee);
    }

    /**
     * 测试根据name查询员工信息
     */
    @Test
    public void testSelectIneByName() {
        Employee employee = employeeMapper.selectOneByName("yaojikai");
        System.out.println(employee);
    }

    /**
     * 测试新增用户
     */
    @Test
    public void testInsertOne() {
        Employee employee = new Employee();
        employee.setEmpName("zhengnan");
        employee.setEmpEmail("zhengnan@qiyu.com");
        employee.setGender("男");
        employee.setDepartmentId(3);
        int i = employeeMapper.insertOne(employee);
        System.out.println(i);
    }

    /**
     * 测试删除用户
     */
    @Test
    public void testDeleteOne() {
        int i = employeeMapper.deleteOne(4);
        System.out.println(i);
    }

    /**
     * 测试修改
     */
    @Test
    public void testUpdateOne() {
        Employee employee = new Employee();
        employee.setEmpId(3);
        employee.setEmpName("zhangda");
        employee.setEmpEmail("zhangda@126.com");
        employee.setGender("男");
        employee.setDepartmentId(2);
        int i = employeeMapper.updateOne(employee);
        System.out.println(i);
    }


    @Test
    public void selectWith() {
        List<Employee> employees = employeeMapper.selectLimitAndOffset(2, 3);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void testCount() {
        int i = employeeMapper.countEmps();
        System.out.println(i);
    }
}
