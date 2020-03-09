package com.jikaigg.ssm.dao;

import com.jikaigg.ssm.domain.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductDao {
    @Select("select * from product")
    List<Product> findAll() throws Exception;
}
