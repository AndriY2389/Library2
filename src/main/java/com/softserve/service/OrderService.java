package com.softserve.service;


import com.softserve.model.Order;

import java.util.List;

public interface OrderService {

    void save(Order entity);

    void delete(Order entity);

    List<Order> findAll();

    void update(Order entity);

    Order findById(Integer id);

    void deleteById(Integer id);
}
