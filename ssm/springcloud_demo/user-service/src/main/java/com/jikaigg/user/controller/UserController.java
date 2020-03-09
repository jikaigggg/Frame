package com.jikaigg.user.controller;

import com.jikaigg.user.pojo.User;
import com.jikaigg.user.service.UserService;
import com.jikaigg.user.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("{id}")
    public User queryById(@PathVariable("id")Long id){
        return userServiceImpl.queryById(id);
    }
}
