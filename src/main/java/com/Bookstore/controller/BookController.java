package com.Bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
    public BookController() {
    }

    @GetMapping({"/"})
    public String home() {
        return "home";
    }

    @GetMapping({"/book_register"})
    public String bookRegister() {
        return "BookRegister";
    }

    @GetMapping({"/available_books"})
    public String getAllBooks() {
        return "BookList";
    }
}
