package com.softserve.controller;

import com.softserve.dto.OrderDTO;
import com.softserve.model.Author;
import com.softserve.model.Order;
import com.softserve.service.BookService;
import com.softserve.service.OrderService;
import com.softserve.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    BookService bookService;
    @Autowired
    ReaderService readerService;

    @GetMapping("/order")
    public String getOrders(Model model) {
        model.addAttribute("orders", orderService.findAll());
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("readers", readerService.findAll());
        return "order/order";
    }

    @PostMapping("/update_order")
    public String updateAuthor(@RequestParam(name = "book") Integer book_id,
                               @RequestParam(name = "dateOfIssuance") String dateOfIssuance,
                               @RequestParam(name = "dateOfReturn") String dateOfReturn,
                               @RequestParam(name = "reader") Integer reader_id,
                               @RequestParam(name = "id") Integer id,
                               Model model) {
        OrderDTO order = new OrderDTO();
        order.setId(id);
        if (book_id != 0) {
            order.setBook(bookService.findById(book_id));
        }
        if (reader_id != 0) {
            order.setReader(readerService.findById(reader_id));
        }
        order.setStart(Date.valueOf(dateOfIssuance));
        order.setFinish(Date.valueOf(dateOfReturn));
        if (!orderService.update(order)) {
            model.addAttribute("invalid_data", "INVALID DATA!!!!!");
            model.addAttribute("readers", readerService.findAll());
            model.addAttribute("orders", orderService.findAll());
            model.addAttribute("books", bookService.findAll());
            return "order/order";
        } else {
            return "redirect:/order";
        }
    }

    @PostMapping("/delete_order")
    public String deleteOrder(@RequestParam(name = "id") Integer id) {
        orderService.deleteById(id);
        return "redirect:/order";
    }

    @PostMapping("/create_order")
    public String createAuthor(@RequestParam(name = "book") Integer book_id,
                               @RequestParam(name = "dateOfIssuance") String dateOfIssuance,
                               @RequestParam(name = "dateOfReturn") String dateOfReturn,
                               @RequestParam(name = "reader") Integer reader_id,
                               Model model) {
        Order order = new Order();
        order.setBooks(bookService.findById(book_id));
        order.setDateOfIssuance(Date.valueOf(dateOfIssuance));
        order.setDateOfReturn(Date.valueOf(dateOfReturn));
        order.setReaders(readerService.findById(reader_id));
        if (book_id == 0 || reader_id == 0) {
            model.addAttribute("orders", orderService.findAll());
            model.addAttribute("books", bookService.findAll());
            model.addAttribute("readers", readerService.findAll());
            model.addAttribute("invalid_data", "INVALID DATA!!!!!");
            return "order/order";
        } else {
            orderService.save(order);
            return "redirect:/order";
        }
    }
}


