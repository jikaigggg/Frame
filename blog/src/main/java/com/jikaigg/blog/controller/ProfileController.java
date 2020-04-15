package com.jikaigg.blog.controller;

import com.jikaigg.blog.dto.PageDTO;
import com.jikaigg.blog.pojo.User;
import com.jikaigg.blog.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/profile/{action}")
    public String profile(@RequestParam(value = "page", defaultValue = "1") Integer page,
                          @RequestParam(value = "size", defaultValue = "5") Integer size,
                          @PathVariable("action") String action,
                          HttpServletRequest request,
                          Model model) {
        User user = (User)request.getSession().getAttribute("user");

        if (user == null){
            return "redirect:/";
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
