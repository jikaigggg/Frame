package com.jikaigg.blog.controller;

import com.jikaigg.blog.dto.PageDTO;
import com.jikaigg.blog.mapper.QuestionMapper;
import com.jikaigg.blog.mapper.UserMapper;
import com.jikaigg.blog.pojo.User;
import com.jikaigg.blog.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {
    @Autowired
    UserMapper userMapper;

    @Autowired
    QuestionService questionService;

    @GetMapping("/profile/{action}")
    public String profile(@RequestParam(value = "page", defaultValue = "1") Integer page,
                          @RequestParam(value = "size", defaultValue = "5") Integer size,
                          @PathVariable("action") String action,
                          HttpServletRequest request,
                          Model model) {
        Cookie[] cookies = request.getCookies();
        User user = null;
        if (cookies!=null && cookies.length != 0){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    //根据token查询数据库中是否有记录，有记录代表用户有信息，不用再次登陆
                    user = userMapper.findByToken(token);
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
        if ("question".equals(action)) {
            model.addAttribute("section", "question");
            model.addAttribute("sectionName", "我的提问");
        }
        if ("reply".equals(action)) {
            model.addAttribute("section", "reply");
            model.addAttribute("sectionName", "最新回复");
        }
        PageDTO pageDTO = questionService.selectList(user.getId(), page, size);
        model.addAttribute("userqueslist",pageDTO);

        return "profile";
    }
}
