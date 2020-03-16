package com.jikaigg.mapper.impl;

import com.jikaigg.mapper.EmployeeMapper;
import com.jikaigg.pojo.Employee;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class EmployeeMapperImpl implements EmployeeMapper {
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<Employee> findAll() {
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        return mapper.findAll();
    }
}
