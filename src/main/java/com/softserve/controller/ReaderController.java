package com.softserve.controller;

import com.softserve.model.Reader;
import com.softserve.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReaderController {

    @Autowired
    ReaderService readerService;

    @GetMapping("/reader")
    public String getReader(Model model) {
        model.addAttribute("readers", readerService.findAll());
        return "reader/reader";
    }

    @PostMapping("/create_reader")
    public String createReader(@RequestParam(name = "FirstName") String firstName,
                               @RequestParam(name = "LastName") String lastName,
                               Model model){
        Reader reader = new Reader();
        reader.setFirstName(firstName);
        reader.setLastName(lastName);

        if (readerService.save(reader)) {
            model.addAttribute("invalid_data", "INVALID DATA!!!!!");
            model.addAttribute("reader", readerService.findAll());
            return "reader/reader";
        } else {
            return "redirect:/reader";
        }
    }


    @PostMapping("/delete_reader")
    public String deleteReader(@RequestParam(name = "id") String id){
        readerService.deleteById(Integer.parseInt(id));
        return "redirect:/reader";
    }

    @PostMapping("/update_reader")
    public String updateReader(@RequestParam(name = "FirstName") String firstName,
                               @RequestParam(name = "LastName") String lastName,
                               @RequestParam(name = "id") Integer id,
                               Model model) {
        Reader reader = new Reader();
        reader.setFirstName(firstName);
        reader.setId(id);
        reader.setLastName(lastName);
        if (!readerService.update(reader)) {
            model.addAttribute("invalid_data", "INVALID DATA!!!!!");
            model.addAttribute("readers", readerService.findAll());
            return "reader/reader";
        } else {
            return "redirect:/reader";
        }
    }
}
