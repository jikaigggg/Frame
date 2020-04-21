package com.jikaigg.web;

import com.jikaigg.pojo.User;
import com.jikaigg.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

@RestController
@Slf4j
@RequestMapping("user")
public class HelloController {
    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public User hello1(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }

    @GetMapping("hello")
    public User hello2() {
        return userService.queryById(41L);
    }

    @GetMapping("hello.do")
    public User hello3() {
        return userService.queryById(41L);
    }
}
