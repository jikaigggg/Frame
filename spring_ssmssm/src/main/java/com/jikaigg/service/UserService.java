package com.jikaigg.service;

import com.jikaigg.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findByName(String name);
}
