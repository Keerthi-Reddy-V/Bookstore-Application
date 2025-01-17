package com.Bookstore.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Bookstore.service.BookService;
import com.Bookstore.entity.Book;
import com.Bookstore.entity.myBookList;
import com.Bookstore.service.myBookListService;

import org.springframework.ui.Model;

 
@Controller
public class BookController {
    public BookController() {
    }

    @Autowired
    private BookService service;

    @Autowired
    private myBookListService myBookService;

    @GetMapping({"/"})
    public String home() {
        return "home";
    }

    @GetMapping({"/book_register"})
    public String bookRegister() {
        return "BookRegister";
    }

    @GetMapping({"/available_books"})
    public ModelAndView getAllBooks() {
        List<Book> list=service.getAllBook();
        // ModelAndView m=new ModelAndView();
        // m.setViewName("BookList");
        // m.addObject("book",list);
        // return m;
        return new ModelAndView("BookList","book",list);  
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b){
        // System.out.println("Book Details: " + b.getAuthor() + ", " + b.getName() + ", " + b.getPrice());
        service.save(b);
        return "redirect:/available_books";
    }
// public String addBook(@RequestParam String name, @RequestParam String author, @RequestParam Double price) {
//     Book book = new Book();
//     book.setName(name);
//     book.setAuthor(author);
//     book.setPrice(price);
//     service.save(book);
//     return "redirect:/available_books";
// }


    @GetMapping("/my_books")
    public String getMyBooks(Model model){
        List<myBookList> list = myBookService.getAllMybooks();
        model.addAttribute("book",list);
        return "myBooks";
    }
    @RequestMapping("/myList/{id}")
    public String getMyList(@PathVariable("id") int id){
        Book b = service.getBookById(id);
        myBookList mb = new myBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
        myBookService.saveMyBooks(mb);
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        Book b = service.getBookById(id);
        model.addAttribute("book", b);
        return "bookEdit";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id){
        service.deleteById(id);
        return "redirect:/available_books";
    }   
   
}
