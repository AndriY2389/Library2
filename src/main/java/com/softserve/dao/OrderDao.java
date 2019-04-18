package com.softserve.dao;

import com.softserve.model.Order;

import java.util.List;

public interface OrderDao {

    public List listAllOrder();

    public void saveOrUpdate(Order order);

    public Order findOrderById(int id);

    public void deleteOrder(int id);

}
