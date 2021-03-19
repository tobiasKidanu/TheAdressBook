package com.example.adressbook.controller;

import com.example.adressbook.entity.Contact;
import com.example.adressbook.repository.ContactRepository;
import com.example.adressbook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping(value = "/all")
    public List<Contact> getAllContacts() {
        return contactService.getAllContact();
    }

    @PostMapping(value = "/create")
    public String addContact(@RequestBody Contact contact) {
        Contact contact1 = contactService.addContact(contact);
        return "Contact was added!!  " + contact1;
    }

    @DeleteMapping(path = "/delete/{id}")
    public String  delete(@PathVariable String id){
        contactService.delete(id);
        return "the contact " + contactRepository.findById(id) + " was deleted";
    }


}
