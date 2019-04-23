package com.softserve.controller;

import com.softserve.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/order")
    public String getOrders(Model model){
        model.addAttribute("orders", orderService.findAll());
        return "order";
    }
}
