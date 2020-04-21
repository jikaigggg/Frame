package com.jikaigg.dao;

import com.jikaigg.domain.Role;

import java.util.List;

public interface RoleDao {
    /**
     * 查询所有结果
     *
     * @return
     */
    List<Role> findAll();
}
