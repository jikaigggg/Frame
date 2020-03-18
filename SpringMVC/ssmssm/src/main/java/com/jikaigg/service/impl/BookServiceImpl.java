package com.jikaigg.service.impl;

import com.jikaigg.dao.BookMapper;
import com.jikaigg.pojo.Books;
import com.jikaigg.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookMapper mapper;

    public void setMapper(BookMapper mapper) {
        this.mapper = mapper;
    }

    public int addBook(Books books) {
        return mapper.addBook(books);
    }

    public int deleteBook(int id) {
        return mapper.deleteBook(id);
    }

    public int updateBook(Books books) {
        return mapper.updateBook(books);
    }

    public Books queryBookById(int id) {
        return mapper.queryBookById(id);
    }

    public List<Books> findAll() {
        return mapper.findAll();
    }
}
