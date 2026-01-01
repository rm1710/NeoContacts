package com.contacts.controllers;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.contacts.exceptions.Helper;



@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    //user dashboard
    @RequestMapping(value = "/dashboard")
    public String userDashboard(){
        System.out.println("user dashboard");
        return "user/dashboard";
    }

    @RequestMapping(value="/profile")
    public String userProfile(Authentication authentication) {
        String username = Helper.getEmailOfLoggedInUser(authentication);

        logger.info("User Logged: {}"+username);

        return "user/profile";
    }
    

}
