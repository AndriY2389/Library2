package com.softserve.service;


import com.softserve.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderService {

    boolean save(Order entity);

    boolean delete(Order entity);

    List<Order> findAll();

    boolean update(Order entity);

    Order findById(Integer id);

    boolean deleteById(Integer id);
}
