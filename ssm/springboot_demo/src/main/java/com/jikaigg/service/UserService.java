package com.jikaigg.service;

import com.jikaigg.pojo.User;

public interface UserService {
    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    User queryById(Long id);

    /**
     * 新增用户
     *
     * @param user
     */
    void insertUser(User user);

}
