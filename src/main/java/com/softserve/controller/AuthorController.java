package com.softserve.controller;

import com.softserve.model.Author;
import com.softserve.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.nio.charset.StandardCharsets;

import static java.nio.charset.StandardCharsets.*;

@Controller
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("/author")
    public String getAuthor(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "author/author";
    }

    @PostMapping("/create_author")
    public String createAuthor(@RequestParam(name = "FirstName") String firstName,
                               @RequestParam(name = "LastName") String lastName,
                               Model model) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        if (!authorService.save(author)) {
            model.addAttribute("invalid_data", "INVALID DATA!!!!!");
            model.addAttribute("authors", authorService.findAll());
            return "author/author";
        } else {
            return "redirect:/author";
        }
    }

    @PostMapping("/delete_author")
    public String deleteAuthor(@RequestParam(name = "id") String id) {
        authorService.deleteById(Integer.parseInt(id));
        return "redirect:/author";
    }

    @PostMapping("/update_author")
    public String updateAuthor(@RequestParam(name = "FirstName") String firstName,
                               @RequestParam(name = "LastName") String lastName,
                               @RequestParam(name = "id") Integer id,
                               Model model) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setId(id);
        author.setLastName(lastName);
        if (!authorService.update(author)){
            model.addAttribute("invalid_data", "INVALID DATA!!!!!");
            model.addAttribute("authors", authorService.findAll());
            return "author/author";
        } else{
            return "redirect:/author";
        }
    }
}
