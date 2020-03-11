package com.jikaigg.service;

import com.jikaigg.domain.Employee;
import com.jikaigg.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    public Employee selectOneById(Integer empId){
        return employeeMapper.selectOneById(empId);
    }
}
