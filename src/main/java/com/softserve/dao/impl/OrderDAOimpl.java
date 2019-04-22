package com.softserve.dao.impl;

import com.softserve.dao.generic.OrderDAO;
import com.softserve.model.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class OrderDAOimpl extends AbstractDAO<Order,Integer> implements OrderDAO {
    public OrderDAOimpl() {
        super(Order.class);
    }
}
