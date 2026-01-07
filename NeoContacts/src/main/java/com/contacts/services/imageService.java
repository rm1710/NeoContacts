package com.contacts.services;

import org.springframework.web.multipart.MultipartFile;

public interface Imageservice{
    String uploadImage(MultipartFile imageFile);
}
