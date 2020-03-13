package com.jikaigg.service;

import com.jikaigg.domain.Department;
import com.jikaigg.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    public Department selectOneById(Integer deptId){
        return departmentMapper.selectOne(deptId);
    }



    public List<Department> selectAll(){
        return departmentMapper.selectAll();
    }

    public List<Department> findAll(){
        return departmentMapper.findAll();
    }

}
