package com.customer.manage.service;

import com.customer.manage.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findALl();
    Customer findById(Integer id);
    void save(Customer customer);
    void remove(Integer id);
}
