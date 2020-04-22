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
    QuestionService questionService;

    @GetMapping("/")
    public String hello(@RequestParam(value = "page", defaultValue = "1") Integer page,
                        @RequestParam(value = "size", defaultValue = "5") Integer size,
                        Model model) {
        PageDTO pageList = questionService.selectList(page, size);
        model.addAttribute("pageList", pageList);
//        System.out.println(questionList);
        return "index";
    }

}
