package com.jikaigg.mapper.impl;

import com.jikaigg.mapper.DeptMapper;
import com.jikaigg.pojo.Dept;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class DeptMapperImpl extends SqlSessionDaoSupport implements DeptMapper {
    public List<Dept> findAll() {
        return getSqlSession().getMapper(DeptMapper.class).findAll();
    }
}
