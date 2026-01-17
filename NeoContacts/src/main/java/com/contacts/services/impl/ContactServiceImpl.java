package com.contacts.services.impl;

import java.util.List;

import com.contacts.entities.Contact;
import com.contacts.repository.ContactRepo;
import com.contacts.services.ContactService;
import com.contacts.entities.User;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepo contactRepo;

    @Override
    public Contact save(Contact contact) {
        String contactId = UUID.randomUUID().toString();
        contact.setId(contactId);
        return contactRepo.save(contact);
    }

    @Override
    public Contact update(Contact contact) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public List<Contact> getAll() {
        return contactRepo.findAll();
    }

    @Override
    public Contact getById(String id) {
        return contactRepo.findById(id).orElseThrow(() -> new RuntimeException("Contact not found"));
    }

    @Override
    public void delete(String id) {
        var contact = contactRepo.findById(id).orElseThrow(() -> new RuntimeException("Contact not found"));
        contactRepo.delete(contact);
    }

    @Override
    public List<Contact> search(String name, String email, String phoneNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    @Override
    public List<Contact> getByUserId(String userId) {
        return contactRepo.findByUserId(userId);
    }

    @Override
    public Page<Contact> getByUser(
        User user,
        int page,
        int size,
        String sortField,
        String direction) {

    if (sortField == null || sortField.isBlank()) {
        sortField = "name"; // default column
    }

    Sort sort = "desc".equalsIgnoreCase(direction)
            ? Sort.by(sortField).descending()
            : Sort.by(sortField).ascending();

    var pageable = PageRequest.of(page, size, sort);

    return contactRepo.findByUser(user, pageable);
}

}