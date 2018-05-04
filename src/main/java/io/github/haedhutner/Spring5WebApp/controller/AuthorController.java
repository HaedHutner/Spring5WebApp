package io.github.haedhutner.Spring5WebApp.controller;

import io.github.haedhutner.Spring5WebApp.repository.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private AuthorRepository authors;

    public AuthorController(AuthorRepository authors) {
        this.authors = authors;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model) {
        model.addAttribute("authors", authors.findAll());

        return "authors";
    }
}
