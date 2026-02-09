package com.contacts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.contacts.entities.Contact;
import com.contacts.entities.User;
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

    @GetMapping(value = "/search", produces = "application/json")
    public Object searchContacts(
            @RequestParam String field,
            @RequestParam String keyword,
            @RequestParam(required = false) String id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {

        // 🔹 If ID is present → return single contact (modal use)
        if (id != null && !id.isEmpty()) {
            return contactService.getById(id);
        }

        // 🔹 TEMP: get logged-in user (replace with SecurityContext)
        User user = getLoggedInUser();

        return switch (field.toLowerCase()) {
            case "name" ->
                    contactService.searchByName(keyword, size, page, "name", "asc", user);
            case "email" ->
                    contactService.searchByEmail(keyword, size, page, "email", "asc", user);
            case "phone" ->
                    contactService.searchByPhoneNumber(keyword, size, page, "phoneNumber", "asc", user);
            default ->
                    throw new IllegalArgumentException("Invalid search field: " + field);
        };
    }

    // ⚠️ Replace this with real authentication logic
    private User getLoggedInUser() {
        User user = new User();
        user.setUserId("1"); // dummy
        return user;
    }
}
