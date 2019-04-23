package com.softserve.dao.impl;

import com.softserve.dao.generic.OrderDAO;
import com.softserve.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAOimpl extends AbstractDAO<Order,Integer> implements OrderDAO {
    public OrderDAOimpl() {
        super(Order.class);
    }
}
