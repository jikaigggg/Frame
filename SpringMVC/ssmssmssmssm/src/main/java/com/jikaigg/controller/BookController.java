package com.jikaigg.controller;

import com.jikaigg.pojo.Books;
import com.jikaigg.service.BookService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("allbook")
    public String list(Model model) {
        List<Books> all = bookService.findAll();
        model.addAttribute("list", all);

        return "allbook";
    }

    @RequestMapping("toaddbook")
    public String toAddPage() {
        return "addBook";
    }

    @RequestMapping("addbook")
    public String addBook(Books books) {
        bookService.addBook(books);
        return "redirect:/book/allbook";
    }

    @RequestMapping("toupdatebook")
    public String toupdatebook(Model model, @Param("id") int id) {
        System.out.println(id);
        Books books = bookService.queryBookById(id);
        model.addAttribute("books", books);
        return "updateBook";
    }

    @RequestMapping("updatebook")
    public String updatebook(Books books) {
        System.out.println(books);
        bookService.updateBook(books);
        return "redirect:/book/allbook";
    }

    @RequestMapping("deletebook/{bookId}")
    public String deletebook(@PathVariable("bookId") int id) {
        bookService.deleteBook(id);
        return "redirect:/book/allbook";
    }

    @RequestMapping("querybook")
    public String querybook(String queryBookName, Model model) {
        Books book = bookService.queryBookByName(queryBookName);
        List<Books> selectAll = new ArrayList<Books>();
        selectAll.add(book);
        if (book == null) {
            selectAll = bookService.findAll();
            model.addAttribute("error", "未查到");
        }
        model.addAttribute("list", selectAll);
        return "allbook";
    }

}
