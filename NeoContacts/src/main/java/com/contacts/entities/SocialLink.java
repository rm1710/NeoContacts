package com.contacts.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import lombok.*;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SocialLink {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String link;
    private String title;

    @ManyToOne
    private Contact contact;
}
