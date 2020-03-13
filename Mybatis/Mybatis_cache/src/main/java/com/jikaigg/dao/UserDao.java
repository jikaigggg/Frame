package com.jikaigg.dao;

import com.jikaigg.domain.User;

import java.util.List;

/**
 * @author jikaigg
 *
 * 用户的持久层接口
 */
public interface UserDao {
    /**
     * 查询所有操作
     * @return
     */
    List<User> findAll();


    /**
     * 根据用户id查询用户信息
     * @param userId
     */
    User findById(Integer userId);

    /**
     * 更新用户信息
     * @param user
     */
    void updateUser(User user);
}
