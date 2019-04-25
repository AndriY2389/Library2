package com.softserve.service.impl;

import com.softserve.dao.generic.OrderDAO;
import com.softserve.dto.OrderDTO;
import com.softserve.model.Order;
import com.softserve.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDAO orderDAO;

    @Override
    @Transactional
    public boolean save(Order entity) {
        orderDAO.save(entity);
        return true;
    }

    @Override
    @Transactional
    public boolean delete(Order entity) {
        orderDAO.delete(entity);
        return true;
    }

    @Override
    public List<Order> findAll() {
        return orderDAO.findAll();
    }

    @Override
    @Transactional
    public boolean update(OrderDTO entity) {
        OrderDTO orderDTO = new OrderDTO(findById(entity.getId()));

        orderDTO.setStart(entity.getStart());
        orderDTO.setFinish(entity.getFinish());
        if(entity.getBook()!=null){
            orderDTO.setBook(entity.getBook());
        }
        if(entity.getReader()!=null){
            orderDTO.setReader(entity.getReader());
        }
        orderDAO.update(orderDTO.getOrder());
        return true;
    }

    @Override
    public Order findById(Integer id) {
        return orderDAO.findById(id);
    }

    @Override
    @Transactional
    public boolean deleteById(Integer id) {
        orderDAO.deleteById(id);
        return true;
    }
}
