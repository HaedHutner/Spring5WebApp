package io.github.haedhutner.Spring5WebApp.controller;

import io.github.haedhutner.Spring5WebApp.repository.PublisherRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublisherController {

    private PublisherRepository publishers;

    public PublisherController(PublisherRepository publishers) {
        this.publishers = publishers;
    }

    @RequestMapping("/publishers")
    public String getPublishers(Model model) {
        model.addAttribute("publishers", publishers.findAll());

        return "publishers";
    }

    public void print() {
        publishers.findAll().forEach(publisher -> {
            System.out.println(publisher.toString());
        });
    }
}
