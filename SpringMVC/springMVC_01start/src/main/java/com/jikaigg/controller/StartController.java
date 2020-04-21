package com.jikaigg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//控制器
@Controller
@RequestMapping("/user")
public class StartController {
    @RequestMapping(path = "/hello", params = {"username=haha"})
    public String sayHello() {
        System.out.println("springMVC");
        return "success";
    }

    /*
     * method属性限制请求方式
     * */
    @RequestMapping(path = "/world", method = {RequestMethod.GET})
    public String world() {
        System.out.println("world");
        return "success";
    }

}
