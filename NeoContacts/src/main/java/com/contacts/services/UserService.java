package com.contacts.services;

import java.util.List;
import java.util.Optional;

import com.contacts.entities.User;

public interface UserService {
    User saveUser(User user);
    Optional<User> getUserById(String userId);
    Optional<User> updateUser(User user);
    void deleteUser(String userId);
    
    boolean isUserExists(String userId);
    boolean isUserExistsByEmail(String email);
    List<User> getAllUsers();
}
