package com.jikaigg.service.impl;

import com.jikaigg.mapper.UserMapper;
import com.jikaigg.pojo.User;
import com.jikaigg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }
}
