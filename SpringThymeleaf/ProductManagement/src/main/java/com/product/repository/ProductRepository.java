package com.product.repository;

import com.product.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    Product findById(int id);

    void save(Product product);
}
