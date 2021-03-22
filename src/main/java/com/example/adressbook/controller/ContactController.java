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
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Contact> getAllContacts() {
        return contactService.getAllContact();
    }

    @GetMapping(path = "/{id}")
    public String getCertainContact(@PathVariable String id) {
        return "The contact " + contactService.getContact(id).toString() + " is here";
    }

    @PostMapping(value = "/create")
    public String addContact(@RequestBody Contact contact) {
        Contact contact1 = contactService.addContact(contact);
        return "Contact was added!!  " + contact1;
    }

    @DeleteMapping(path = "/delete/{id}")
    public String delete(@PathVariable String id) {
        if (!contactRepository.existsById(id)) {
            throw new IllegalAccessError("Contact does not now exist");
        }
        contactService.delete(id);
        return "the contact " + contactRepository.findById(id) + " was deleted";
    }

    @PutMapping(path = "/update/{id}")
    public String updateContact(@PathVariable String id, @RequestBody Contact contact) {
        Contact contact1 = contactService.updateContact(id, contact);
        return "The " + contact1 + " has been updated";
    }
}
