package com.softserve.service;


import com.softserve.dto.OrderDTO;
import com.softserve.model.Order;

import java.util.List;

public interface OrderService {

    boolean save(Order entity);

    boolean delete(Order entity);

    List<Order> findAll();

    boolean update(OrderDTO entity);

    Order findById(Integer id);

    boolean deleteById(Integer id);
}
