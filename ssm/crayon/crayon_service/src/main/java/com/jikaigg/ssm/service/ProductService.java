package com.jikaigg.ssm.service;

import com.jikaigg.ssm.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll() throws Exception;
}
