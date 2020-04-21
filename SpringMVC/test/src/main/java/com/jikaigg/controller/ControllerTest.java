package com.jikaigg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;

@Controller
public class ControllerTest implements Serializable {
    @RequestMapping("test")
    public String test(String username) {
        System.out.println("用户名是" + username);
        return "success";
    }
}
