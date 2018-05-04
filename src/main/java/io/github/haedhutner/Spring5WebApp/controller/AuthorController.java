package io.github.haedhutner.Spring5WebApp.controller;

import io.github.haedhutner.Spring5WebApp.model.Author;
import io.github.haedhutner.Spring5WebApp.repository.AuthorRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthorController {

    private AuthorRepository authors;

    public AuthorController(AuthorRepository authors) {
        this.authors = authors;
    }

    @RequestMapping(path = "/authors", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAuthors(Model model) {
        model.addAttribute("authors", authors.findAll());

        return "authors";
    }

    @RequestMapping(value = "/authors/form", method = RequestMethod.GET)
    public String authorForm(Model model) {
        Author author = new Author();

        model.addAttribute("author", author);

        return "authorForm";
    }

    @RequestMapping("/authors/add")
    public String addAuthor(@ModelAttribute("author") Author model) {
        authors.save(model);
        return "redirect:/authors";
    }
}
