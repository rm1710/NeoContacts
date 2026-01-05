package com.contacts.forms;

import org.springframework.web.multipart.MultipartFile;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactForm {
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String description;
    private String favorite;
    private String websiteLink;
    private String linkedInLink;

    private MultipartFile profileImage;

}
