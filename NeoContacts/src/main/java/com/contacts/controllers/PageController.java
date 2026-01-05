package com.contacts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.contacts.entities.User;
import com.contacts.exceptions.Message;
import com.contacts.exceptions.MessageType;
import com.contacts.forms.UserForm;
import com.contacts.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PageController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String root() {
        return "redirect:/home";
    }

    @RequestMapping("/home")
    public String home(Model model) {
        System.out.println("home page handler");
        model.addAttribute("name", "substring technology");
        model.addAttribute("TIMSCDR", "kandivali east");
        model.addAttribute("github", "https://github.com/rm1710");
        return "home";
    }

    // about route
    @RequestMapping("/about")
    public String aboutPage() {
        System.out.println("About page loading");
        return "about";
    }

    @RequestMapping("/services")
    public String servicesPage() {
        System.out.println("Services page loading");
        return "services";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/login")
    public String login() {
        return new String("login");
    }

    @GetMapping("/register")
    public String register(Model model) {
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
        return "register";
    }

    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult,
            HttpSession session) {
        System.out.println("processing register form");
        System.out.println(userForm);
        // fetch the form data
        // validate the for data
        if (rBindingResult.hasErrors()) {
            return "register";
        }
        // save to database
        // userService
        // User user = User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())
        // .profilePic(null)
        // .build();

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic(
                "https://www.bing.com/images/search?view=detailV2&ccid=TtQ2FWvw&id=CB9D09309919EC8067D3AE38EDEBB55569A76811&thid=OIP.TtQ2FWvwnpv3wFG-Ylin-AHaHa&mediaurl=https%3a%2f%2fimg.freepik.com%2ffree-vector%2fblue-circle-with-white-user_78370-4707.jpg&exph=626&expw=626&q=profile+picture+online+link&FORM=IRPRST&ck=369D08C65225B6E2B4F2E68D89BBFBAE&selectedIndex=13&itb=0");
        User savedUser = userService.saveUser(user);
        System.out.println(savedUser);

        Message message = Message.builder().content("Registration Successfully!!!").type(MessageType.green).build();

        session.setAttribute("message", message);

        // message= "Registration successful";
        return "redirect:/register";
    }
}
