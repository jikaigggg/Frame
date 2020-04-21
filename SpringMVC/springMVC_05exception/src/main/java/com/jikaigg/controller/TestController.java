package com.jikaigg.controller;


import com.jikaigg.exception.TestException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class TestController {
    @RequestMapping("testException")
    public String testException() throws TestException {
        System.out.println("testException执行了。。。");
        try {
            //模拟一个异常
            int i = 10 / 0;
        } catch (Exception e) {
            //打印异常信息
            e.printStackTrace();
            //抛出自定义异常信息
            throw new TestException("查询所有用户出现了异常");
        }
        return "success";
    }
}
