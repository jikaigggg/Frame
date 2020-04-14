package com.jikaigg.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProfileController {
    @GetMapping("/profile/{action}")
    public String profile(@PathVariable("action")String action, Model model){
        if ("question".equals(action)){
            model.addAttribute("section","question");
        }
        return "profile";
    }
}
