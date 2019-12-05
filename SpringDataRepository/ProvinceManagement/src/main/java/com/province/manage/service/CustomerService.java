package com.province.manage.service;

import com.province.manage.model.Customer;
import com.province.manage.model.Province;

public interface CustomerService {
    Iterable<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    Iterable<Customer> findAllByProvince(Province province);
}
