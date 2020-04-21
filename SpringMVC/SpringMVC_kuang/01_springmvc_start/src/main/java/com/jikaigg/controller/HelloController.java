package com.jikaigg.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HelloController {
    @RequestMapping("hello")
    public String handleRequest(Model model) {
        model.addAttribute("msg", "helloController!!!");

        return "hello";
    }


    @GetMapping("add/{a}/{b}")
    public String add1(@PathVariable int a, @PathVariable int b, Model model) {
        int res = a + b;
        model.addAttribute("msg", "helloController1!!!" + res);
        return "hello";
    }

    @PostMapping("add/{a}/{b}")
    public String add2(@PathVariable int a, @PathVariable int b, Model model) {
        int res = a + b;
        model.addAttribute("msg", "helloController2!!!" + res);
        return "hello";
    }

    @DeleteMapping("add/{a}/{b}")
    public String add3(@PathVariable int a, @PathVariable int b, Model model) {
        int res = a + b;
        model.addAttribute("msg", "helloController3!!!" + res);
        return "hello";
    }

    @PutMapping("add/{a}/{b}")
    public String add4(@PathVariable int a, @PathVariable int b, Model model) {
        int res = a + b;
        model.addAttribute("msg", "helloController4!!!" + res);
        return "hello";
    }


    @RequestMapping("zhaungfa")
    public String test2() {
        return "/index.jsp";
    }

    @RequestMapping("redirect")
    public String test3() {
        return "redirect:/index.jsp";
    }

    @RequestMapping("a1")
    public void ajaxtest(String name, HttpServletResponse response) throws IOException {
        System.out.println(name);
        if ("yaojikai".equals(name)) {
            response.getWriter().write("true");
        } else {
            response.getWriter().write("false");
        }
    }

}
