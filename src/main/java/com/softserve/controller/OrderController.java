package com.softserve.controller;

import com.softserve.model.Author;
import com.softserve.model.Order;
import com.softserve.service.BookService;
import com.softserve.service.OrderService;
import com.softserve.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    BookService bookService;
    @Autowired
    ReaderService readerService;

    @GetMapping("/order")
    public String getOrders(Model model){
        model.addAttribute("orders", orderService.findAll());
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("readers", readerService.findAll());
        return "order/order";
    }

    @PostMapping("/order_update")
    public String updateAuthor(@RequestParam(name = "book") Integer book_id,
                               @RequestParam(name = "dateOfIssuance") String dateOfIssuance,
                               @RequestParam(name = "dateOfReturn") String dateOfReturn,
                               @RequestParam(name = "reader") Integer reader,
                               Model model) {
        Order order = new Order();
//        order.setId();
        order.setBooks(bookService.findById(book_id));
        order.setDateOfIssuance(Date.valueOf(dateOfIssuance));
        order.setDateOfReturn(Date.valueOf(dateOfReturn));
        order.setReaders(readerService.findById(reader));
        if (!orderService.update(order)) {
            model.addAttribute("invalid_data", "INVALID DATA!!!!!");
            model.addAttribute("orders", orderService.findAll());
            return "order/order";
        } else {
            return "redirect:/order";
        }
    }

    @PostMapping("/create_order")
    public String createAuthor(@RequestParam(name = "book") Integer book_id,
                               @RequestParam(name = "dateOfIssuance") String dateOfIssuance,
                               @RequestParam(name = "dateOfReturn") String dateOfReturn,
                               @RequestParam(name = "reader") Integer reader,
                               Model model) {
        Order order = new Order();
        order.setBooks(bookService.findById(book_id));
        order.setDateOfIssuance(Date.valueOf(dateOfIssuance));
        order.setDateOfReturn(Date.valueOf(dateOfReturn));
        order.setReaders(readerService.findById(reader));
        if (!orderService.save(order)) {
            model.addAttribute("invalid_data", "INVALID DATA!!!!!");
            model.addAttribute("orders", orderService.findAll());
            return "order/order";
        } else {
            return "redirect:/order";
        }
    }
}


