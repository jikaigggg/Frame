package com.jikaigg.springbootstart.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
public class HelloController implements Serializable {
    public Model hello(Model model) {
        model.addAttribute("msg", "xxx");
        return model;
    }
}
