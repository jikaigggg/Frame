package com.jikaigg.mapper;

import com.jikaigg.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {
    List<Employee> findAll();
}
