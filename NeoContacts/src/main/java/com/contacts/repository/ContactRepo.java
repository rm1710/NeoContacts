package com.contacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.contacts.entities.Contact;
import com.contacts.entities.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


@Repository
public interface ContactRepo extends JpaRepository<Contact, String> {
    //find the contact by user

    Page<Contact> findByUser(User user, Pageable Pageable);

    @Query("SELECT c FROM Contact c WHERE c.user.id=:userId")
    List<Contact> findByUserId(String userId);
}
