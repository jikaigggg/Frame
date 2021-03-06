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

    /**
     * 保存用户
     *
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     *
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户
     *
     * @param userId
     */
    void deleteUser(Integer userId);

    /**
     * 根据用户id查询用户信息
     *
     * @param userId
     */
    User findById(Integer userId);

    /**
     * 根据名称模糊查询用户信息
     *
     * @param username
     * @return
     */
    List<User> findByName(String username);

}
