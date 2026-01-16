package com.contacts.services;

import java.util.List;

import com.contacts.entities.Contact;
import com.contacts.entities.User;

public interface ContactService {
    Contact save(Contact contact);

    Contact update(Contact contact);

    List<Contact> getAll();

    Contact getById(String id);

    void delete(String id);

    List<Contact> search(String name, String email, String phoneNumber);

    List<Contact> getByUserId(String userId);

    List<Contact> getByUser(User user);
}
