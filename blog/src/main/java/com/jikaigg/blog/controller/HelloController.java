package com.jikaigg.blog.controller;

import com.jikaigg.blog.dto.PageDTO;
import com.jikaigg.blog.dto.QuestionDTO;
import com.jikaigg.blog.mapper.QuestionMapper;
import com.jikaigg.blog.mapper.UserMapper;
import com.jikaigg.blog.pojo.Question;
import com.jikaigg.blog.pojo.User;
import com.jikaigg.blog.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    QuestionService questionService;

    @GetMapping("/")
    public String hello(@RequestParam(value = "page", defaultValue = "1") Integer page,
                        @RequestParam(value = "size", defaultValue = "5") Integer size,
                        HttpServletRequest request,
                        Model model) {
        //在访问首页的时候校验用户是否在是登陆状态，验证数据库中是否已有数据
        Cookie[] cookies = request.getCookies();
        if (cookies!=null){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    //根据token查询数据库中是否有记录，有记录代表用户有信息，不用再次登陆
                    User user = userMapper.findByToken(token);
                    if (user != null) {
                        //将查询出来的用户name存入session，前段可以直接取出来
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }else {
            return "index";
        }

        PageDTO pageList = questionService.selectList(page,size);

        model.addAttribute("pageList", pageList);
//        System.out.println(questionList);
        return "index";
    }
}
