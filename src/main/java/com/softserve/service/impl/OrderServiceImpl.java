package com.softserve.service.impl;

import com.softserve.dao.generic.OrderDAO;
import com.softserve.model.Order;
import com.softserve.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDAO orderDAO;

    @Override
    public void save(Order entity) {

    }

    @Override
    public void delete(Order entity) {

    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public void update(Order entity) {

    }

    @Override
    public Order findById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
