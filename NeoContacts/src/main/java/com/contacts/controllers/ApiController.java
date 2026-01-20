package com.contacts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contacts.entities.Contact;
import com.contacts.services.ContactService;

@RestController
@RequestMapping("/contacts")
public class ApiController {
    @Autowired
    private ContactService contactService;

    @GetMapping(value = "/{contactId}", produces = "application/json")
    public Contact getContact(@PathVariable String contactId){
        return contactService.getById(contactId);
    }
}
