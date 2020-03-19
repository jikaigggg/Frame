package com.jikaigg.dao;

import com.jikaigg.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
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
    int deleteBook(@Param("id") int id);

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
    Books queryBookById(@Param("id") int id);

    /**
     * 查询所有书
     * @return
     */
    List<Books> findAll();

    Books queryBookByName(@Param("name") String name);
}
