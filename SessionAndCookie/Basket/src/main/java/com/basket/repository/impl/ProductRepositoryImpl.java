package com.basket.repository.impl;

import com.basket.model.Product;
import com.basket.repository.ProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements ProductRepository {
    private static final Map<Integer, Product> products;
    private static final String defaultImg="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQx2bXc92bNa5VFRuQiRino96_py-E0_74Xt6bDeVcbwvKibulJAg&s";
    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "GTFS", 1000, "Fender Stratocaster", defaultImg));
        products.put(2, new Product(2, "GTFT", 1400, "Fender Telecaster", defaultImg));
        products.put(3, new Product(3, "GTLP", 2200, "Gibson Les Paul", defaultImg));
        products.put(4, new Product(4, "GTGS", 1410, "Gibson SG", defaultImg));
        products.put(5, new Product(5, "GTFV", 13200, "Gibson Flying V", defaultImg));
        products.put(6, new Product(6, "GTSS", 4200, "Superstrat", defaultImg));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product findById(int id) {
        Product product = products.get(id);
        return product;
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }
}
