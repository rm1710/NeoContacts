package com.contacts.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model) {
        System.out.println("home page handler");
        model.addAttribute("name","substring technology");
        model.addAttribute("TIMSCDR","kandivali east");
        model.addAttribute("github", "https://github.com/rm1710");
        return "home";
    }

    //about route
    @RequestMapping("/about")
    public String aboutPage(){
        System.out.println("About page loading");
        return "about";
    }
    @RequestMapping("/services")
    public String servicesPage(){
        System.out.println("Services page loading");
        return "services";
    }

    @GetMapping("/contact")
    public String contact(){
        return new String("contact ");
    }

    @GetMapping("/login")
    public String login(){
        return new String("login");
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }
}
