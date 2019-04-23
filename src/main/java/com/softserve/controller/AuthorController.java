package com.softserve.controller;

import com.softserve.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("/author")
    public String getOrders(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "author/author";

    }
}
