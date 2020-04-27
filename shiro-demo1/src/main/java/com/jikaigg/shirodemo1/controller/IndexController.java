package com.jikaigg.shirodemo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.RequestWrapper;

@Controller
public class IndexController {
    @RequestMapping(value = {"/","index"})
    public String toIndex(Model model){
        model.addAttribute("msg","yaojikai");
        return "index";
    }

    @RequestMapping("/user/add")
    public String add(){
        return "user/add";
    }

    @RequestMapping("/user/update")
    public String update(){
        return "user/update";
    }
}
