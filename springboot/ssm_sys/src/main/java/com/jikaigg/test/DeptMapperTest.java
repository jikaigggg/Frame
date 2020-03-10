package com.jikaigg.test;

import com.jikaigg.domain.Department;
import com.jikaigg.mapper.DepartmentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:springmvc.xml"})
public class DeptMapperTest {
    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 测试新增
     */
    @Test
    public void testInsertDept(){
        Department department = new Department();
        department.setDeptId(4);
        department.setDeptName("航天");
        department.setDeptLeader("songjiang");
        int i = departmentMapper.insertDept(department);
        System.out.println(i);
    }
    /**
     * 测试修改
     */
    @Test
    public void testUpdateDept(){
        Department department = new Department();
        department.setDeptId(2);
        department.setDeptName("睡觉");
        department.setDeptLeader("liububu");
        int i = departmentMapper.updateOne(department);
        System.out.println(i);
    }

    /**
     * 测试根据id查询
     */
    @Test
    public void testSelectOneById(){
        Department department = departmentMapper.selectOne(2);
        System.out.println(department);
    }

    /**
     * 测试修改
     */
    @Test
    public void testSelectOneByName(){
        Department liububu = departmentMapper.selectOneByName("睡觉");
        System.out.println(liububu);
    }

    /**
     * 测试修改
     */
    @Test
    public void testSelectAll(){
        List<Department> departments = departmentMapper.selectAll();
        for (Department department : departments) {
            System.out.println(department);
        }
    }




}
