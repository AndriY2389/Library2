package com.softserve.dto;

import com.softserve.model.Book;
import com.softserve.model.Order;
import com.softserve.model.Reader;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Getter
@Setter
public class OrderDTO {
    private Integer id;
    private Book book = null;
    private Date start;
    private Date finish;
    private Reader reader = null;

    public OrderDTO(){

    }

    public OrderDTO(Order order){
        id = order.getId();
        book = order.getBooks();
        start = (Date) order.getDateOfIssuance();
        finish = (Date) order.getDateOfReturn();
        reader = order.getReaders();
    }

    public Order getOrder(){
        Order order = new Order();
        order.setBooks(book);
        order.setDateOfIssuance(start);
        order.setDateOfReturn(finish);
        order.setId(id);
        order.setReaders(reader);
        return order;
    }
}
