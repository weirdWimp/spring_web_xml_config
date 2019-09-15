package com.learn.something.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping({"/","/home"})
    public String home(Model model) {
        model.addAttribute("title", "Spring Web");
        model.addAttribute("body", "Hello World!");
        return "home";
    }

}
