package com.softserve.controller;

import com.softserve.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReaderController {

    @Autowired
    ReaderService readerService;

    @GetMapping("/reader")
    public String getOrders(Model model) {
        model.addAttribute("readers", readerService.findAll());
        return "reader/reader";
    }
}
