package com.softserve.controller;

import com.softserve.service.BookService;
import com.softserve.service.OrderService;
import com.softserve.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/delete_order")
    public String deleteOrder(@RequestParam( name = "id") Integer id) {
        orderService.deleteById(id);
        return "redirect:/order";
    }
}
