package com.jikaigg.service;

import com.jikaigg.pojo.Books;

import java.util.List;

public interface BookService {
    /**
     * 增加一本书
     * @param books
     * @return
     */
    int addBook(Books books);

    /**
     * 删除一本书
     * @param id
     * @return
     */
    int deleteBook(int id);

    /**
     * 更新一本书
     * @param books
     * @return
     */
    int updateBook(Books books);

    /**
     * 根据id查询一本书
     * @param id
     * @return
     */
    Books queryBookById(int id);

    /**
     * 查询所有书
     * @return
     */
    List<Books> findAll();
}
