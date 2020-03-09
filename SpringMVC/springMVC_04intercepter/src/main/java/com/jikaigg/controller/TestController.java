package com.jikaigg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class TestController {
    @RequestMapping("testIntercepter")
    public String testIntercepter(){
        System.out.println("testIntercepter执行了。。。");
        return "success";
    }
}
