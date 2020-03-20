package com.jikaigg.controller;

import com.jikaigg.pojo.User;
import com.jikaigg.pojo.UserVo;
import com.jikaigg.service.UserService;
import com.jikaigg.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @RequestMapping("login")
    public String userLogin(String name){
        System.out.println(name);
        String msg = null;
        System.out.println(userService.findByName(name));
        if (userService.findByName(name) != null){
            msg = "OK";
        }
        else {
            msg ="FAIL";
        }
        System.out.println(msg);
        return msg;
    }

    @RequestMapping("password")
    public String password(@RequestBody UserVo userVo){
        System.out.println(userVo);
        User user = userService.findByName(userVo.getUsername());
        if (userVo.getPassword() == user.getAge()){
            return "hello";
        }else {
            return "redirect:index.jsp";
        }
    }
}
