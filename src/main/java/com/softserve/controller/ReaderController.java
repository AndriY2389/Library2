package com.softserve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReaderController {
    @GetMapping("/reader")
    public String getOrders(){
        return "reader/reader";
    }
}
