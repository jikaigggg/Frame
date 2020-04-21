package com.jikaigg.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${name}")
    private String name;

    @Value("${person.addr}")
    private String addr;

    @RequestMapping("test1")
    public String test1() {
        return "hello world!!!";
    }

    @RequestMapping("test2")
    public String test2() {
        // 获得配置文件的信息
        System.out.println(addr);

        return "name:" + name + "\r\n addr:" + addr;
    }
}
