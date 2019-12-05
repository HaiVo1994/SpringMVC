package com.province.manage.service.impl;

import com.province.manage.model.Customer;
import com.province.manage.model.Province;
import com.province.manage.repository.CustomerRepository;
import com.province.manage.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiecImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Iterable<Customer> findAllByProvince(Province province) {
        return customerRepository.findAllByProvince(province);
    }
}
