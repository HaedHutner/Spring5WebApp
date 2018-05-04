package io.github.haedhutner.Spring5WebApp.controller;

import io.github.haedhutner.Spring5WebApp.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private BookRepository books;

    public BookController(BookRepository books) {
        this.books = books;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", books.findAll());

        return "books";
    }

}
