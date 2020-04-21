package com.jikaigg.test;

import com.jikaigg.domain.Department;
import com.jikaigg.service.DepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:springmvc.xml"})
public class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;

    @Test
    public void testSelectAll() {
        List<Department> departments = departmentService.selectAll();
        for (Department department : departments) {
            System.out.println(department);
        }
    }

    @Test
    public void testFindAll() {
        List<Department> departments = departmentService.findAll();
        for (Department department : departments) {
            System.out.println(department);
        }
    }
}
