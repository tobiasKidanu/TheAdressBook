package com.example.adressbook.controller;

import com.example.adressbook.entity.Contact;
import com.example.adressbook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;
/*
    @PostMapping
    public ResponseEntity addContact(@RequestBody Contact contact) {
        contactService.addContact(contact);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    } */

    @RequestMapping("/getallcontacts")
    public String getAllContacts(){
        List<Contact> contacts = contactService.getAllContacts();
        return contacts.toString();
    }
}
