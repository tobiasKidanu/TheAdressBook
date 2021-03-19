package com.example.adressbook.controller;

import com.example.adressbook.entity.Contact;
import com.example.adressbook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping(value = "/all")
    public List<Contact> getAllContacts() {
        return contactService.getAllContact();
    }

    @PostMapping(value = "/create")
    public String addContact(@RequestBody Contact contact) {
        Contact contact1 = contactService.addContact(contact);
        return "Contact was added!!  " + contact1;
    }

    @DeleteMapping(value = "/{id}")
    public String deleteContact(@RequestBody Contact contact) {
        contactService.deleteContact(contact);
        return contact + " was deleted";
    }


}
