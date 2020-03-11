package com.jikaigg.controller;

import com.jikaigg.domain.Employee;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class LoginController {
    @RequestMapping("login")
    @ResponseBody
    public int login(HttpServletRequest request) {
        String username = request.getParameter("name");
        String password = request.getParameter("pwd");
        System.out.println(username);
        System.out.println(password);
        int result = 1;
        return result;
    }

    @RequestMapping("testAjax")
    public @ResponseBody int testAjax(@RequestBody Employee employee){
        System.out.println("testAjax执行了...");
        //客户端发送的ajax请求，传的是json的字符串，后端已经把json字符串风转到user对象中
        System.out.println(employee);
        //做响应,模拟查询数据库后出现了数据变化
        int result = 1;
        return result;

    }

}
