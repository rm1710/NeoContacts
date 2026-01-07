package com.contacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.contacts.entities.Contact;
import com.contacts.entities.User;

import java.util.List;


@Repository
public interface ContactRepo extends JpaRepository<Contact, String> {
    //find the contact by user

    List<Contact> findByUser(User user);

    @Query("SELECT c FROM Contact c WHERE c.user.id=:userId")
    List<Contact> findByUserId(String userId);
}
