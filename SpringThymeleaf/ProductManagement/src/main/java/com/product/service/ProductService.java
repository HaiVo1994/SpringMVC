package com.product.service;

import com.product.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(int id);

    void save(Product product);
}
