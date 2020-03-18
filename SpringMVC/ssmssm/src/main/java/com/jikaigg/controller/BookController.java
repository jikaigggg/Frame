package com.jikaigg.controller;

import com.jikaigg.pojo.Books;
import com.jikaigg.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("allbook")
    public String list(Model model){
        List<Books> all = bookService.findAll();
        model.addAttribute("list",all);

        return "allbook";
    }
}
