package com.softserve.controller;


import com.softserve.model.Author;
import com.softserve.model.Book;
import com.softserve.service.AuthorService;
import com.softserve.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;

    @GetMapping("/book")
    public String getBook(Model model) {
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("authors", authorService.findAll());
        return "book/book";
    }

    @PostMapping("/delete_book")
    public String deleteBook(@RequestParam(name = "id") String id) {
        bookService.deleteById(Integer.parseInt(id));
        return "redirect:/book";
    }

    @PostMapping("/create_book")
    public String createBook(@RequestParam(name = "name") String name,
                             @RequestParam(name = "author") String idOfAuthor,
                             @RequestParam(name = "releaseDate") String releaseDate,
                             Model model) {

        System.out.println(releaseDate);
        Author author = authorService.findById(Integer.parseInt(idOfAuthor));
        Book book = new Book();
        book.setReleaseDate(java.sql.Date.valueOf(releaseDate));
        book.setName(name);
        book.setAvailable(true);
        book.setAuthor(author);


        if (!bookService.save(book) || Integer.parseInt(idOfAuthor) == 0) {
            model.addAttribute("invalid_data", "INVALID DATA!!!!!");
            model.addAttribute("books", bookService.findAll());
            model.addAttribute("authors", authorService.findAll());
            return "book/book";
        } else {
            return "redirect:/book";
        }


    }

}