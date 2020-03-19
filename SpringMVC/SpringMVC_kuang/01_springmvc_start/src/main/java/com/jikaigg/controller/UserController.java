package com.jikaigg.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jikaigg.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping(value = "json1")
    @ResponseBody  //不会走视图解析器，直接返回一个字符串
    public String json1() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> users = new ArrayList<User>();
        User user1  = new User("yaojikai1",18,"男");
        User user2  = new User("yaojikai2",18,"男");
        User user3  = new User("yaojikai3",18,"男");
        User user4  = new User("yaojikai4",18,"男");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        String s = objectMapper.writeValueAsString(users);
        //String string = users.toString();
        return s;
    }

    @RequestMapping("a2")
    @ResponseBody
    public List<User> a2(){
        List<User> users = new ArrayList<User>();
        users.add(new User("yaojikai",18,"男"));
        users.add(new User("shimengyu",18,"女"));
        users.add(new User("xiaoxin",18,"男"));
        users.add(new User("fengjian",18,"男"));
        return users;
    }
    @RequestMapping("login")
    @ResponseBody
    public String login(String name){
        System.out.println(name);
        String msg = null;
        if (name!=null){
            if ("yaojikai".equals(name)){
                msg = "OK";
            }else {
                msg = "fail";
            }
        }
        return msg;
    }

    /*@RequestMapping("json2")
    @ResponseBody
    public String test2() throws JsonProcessingException {
        Date date = new Date();
        *//*SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd");
        System.out.println(sdf);
        String time = sdf.format(date);
        System.out.println(time);
        System.out.println(date);*//*
        return new ObjectMapper().writeValueAsString();
    }*/
}
