package com.softserve.controller;


import com.softserve.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/book")
    public String getBook(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "book";
    }

//    @PostMapping("/book-sout")
//    public String soutBook(@RequestParam(name="name") String name,
//                           @RequestParam(name="date") String date){
//        System.out.println(name);
//        System.out.println(date);
//        return "book/book";
//    }



}