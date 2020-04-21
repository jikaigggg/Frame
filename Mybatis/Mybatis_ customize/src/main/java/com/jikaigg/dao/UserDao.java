package com.jikaigg.dao;

import com.jikaigg.domain.User;

import java.util.List;

/**
 * @author jikaigg
 * <p>
 * 用户的持久层接口
 */
public interface UserDao {
    /**
     * 查询所有操作
     *
     * @return
     */
    List<User> findAll();
}
