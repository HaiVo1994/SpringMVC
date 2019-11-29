package com.customer.manage.repository;

import java.util.List;

public interface Repository <TD>{
    List<TD> findAll();
    TD findById(Integer id);
    void save(TD model);
    void remove(Integer id);
}
