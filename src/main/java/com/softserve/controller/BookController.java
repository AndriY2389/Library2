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

import java.util.Collections;
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
                            // @RequestParam(name = "author") Integer idOfAuthor,
                             @RequestParam(name = "releaseDate") Date releaseDate,
                             @RequestParam(name = "available")Boolean available){
        //Author author = authorService.findById(Integer.parseInt(idOfAuthor));
        //
        Book book = new Book();
        book.setReleaseDate(releaseDate);
        book.setName(name);
        book.setAvailable(available);
        //book.setAuthors(Collections.singletonList(author));



        bookService.save(book);
        return "redirect:/book";
    }

}