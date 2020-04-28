package com.jikaigg.shirodemo1.service.impl;

import com.jikaigg.shirodemo1.mapper.UserMapper;
import com.jikaigg.shirodemo1.pojo.User;
import com.jikaigg.shirodemo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User queryUserByName(String username) {
        return userMapper.queryUserByName(username);
    }
}
