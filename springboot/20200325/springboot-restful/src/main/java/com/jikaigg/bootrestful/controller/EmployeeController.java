package com.jikaigg.bootrestful.controller;

import com.jikaigg.bootrestful.dao.DepartmentDao;
import com.jikaigg.bootrestful.dao.EmployeeDao;
import com.jikaigg.bootrestful.entities.Department;
import com.jikaigg.bootrestful.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.jws.WebParam;
import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 查询所有员工，返回列表页面
     * @return
     */

    @GetMapping("/emps")
    public String list(Model model){

        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps",all);
        return "emp/list";

    }


    //来到员工添加页面
    @GetMapping("/emp")
    public String addEmployeePage(Model model){
        //查出所有的部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);

        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmployee(Employee employee){
        employeeDao.save(employee);
        System.out.println(employee);
        return "redirect:/emps";
    }

}
