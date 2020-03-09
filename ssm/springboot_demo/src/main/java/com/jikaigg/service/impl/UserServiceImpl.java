package com.jikaigg.service.impl;

import com.jikaigg.mapper.UserMapper;
import com.jikaigg.pojo.User;
import com.jikaigg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public void insertUser(User user) {
        userMapper.insert(user);
    }
}
