package com.contacts.services;

import org.springframework.web.multipart.MultipartFile;

public interface ImgService {
    String uploadImage(MultipartFile imageFile, String filename);

    String getUrlFromPublicId(String publicId);

}
