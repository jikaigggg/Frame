package com.jikaigg.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("anno")
public class AnnoController {
    /**
     * 获取请求参数，解决请求参数与类中定义参数不一致的问题
     * @RequestParam(name="uname",required = false) 将请求体中的uname转换为paramTest类中定义的username字段，required表示这个参数是不是必须传的，默认为true
     * @param username
     * @return
     */
    @RequestMapping("requestparam")
    public String paramTest(/*@RequestParam(name="uname",required = false) */String username){
        System.out.println("paramTest");
        System.out.println(username);
        return "success";
    }

    /**
     * 获取请求体注解案例
     * @RequestBody
     * @param body
     * @return
     */
    @RequestMapping("requestbody")
    public String bodyTest(@RequestBody String body){
        System.out.println("requestbody");
        System.out.println(body);
        return "success";
    }

    @RequestMapping("pathVariable/{sid}")
    public String pathVariableTest(@PathVariable(name = "sid") String id){
        System.out.println("pathVariable");
        System.out.println(id);
        return "success";
    }
}
