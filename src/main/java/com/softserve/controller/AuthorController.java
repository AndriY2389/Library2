package com.softserve.controller;

import com.softserve.model.Author;
import com.softserve.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("/author")
    public String getAuthor(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "author";
    }

    /*@GetMapping("/author_false_validation")
    public String falseValidation(Model model){
        model.addAttribute("falseValidation","invalid data");
        return "author/author";
    }*/

    @PostMapping
    public String createAuthor(@RequestParam(name = "FirstName") String firstName,
                               @RequestParam(name = "LastName") String lastName){

        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorService.save(author);
        return "redirect:/author";
    }
}
