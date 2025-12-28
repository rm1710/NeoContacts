package com.contacts.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/user")
public class UserController {

    //user dashboard
    @RequestMapping(value = "/dashboard")
    public String userDashboard(){
        System.out.println("user dashboard");
        return "user/dashboard";
    }

    @RequestMapping(value="/profile")
    public String userProfile() {
        return "user/profile";
    }
    

}
