package com.jikaigg.blog.controller;

import com.jikaigg.blog.mapper.UserMapper;
import com.jikaigg.blog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {
    @Autowired
    UserMapper userMapper;
    @GetMapping("/")
    public String hello(HttpServletRequest request){
        //在访问首页的时候校验用户是否在是登陆状态，验证数据库中是否已有数据
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")){
                String token = cookie.getValue();
                //根据token查询数据库中是否有记录，有记录代表用户有信息，不用再次登陆
                User user = userMapper.findByToken(token);
                if (user!=null){
                    //将查询出来的用户name存入session，前段可以直接取出来
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }

        return "index";
    }
}
