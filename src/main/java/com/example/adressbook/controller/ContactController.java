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
        return contactService.getAllContacts();
    }

    @PostMapping(value = "/create")
    public void addContact(@RequestBody Contact contact) {
        contactService.addContact(contact);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String  delete(@PathVariable String id){
        contactService.delete(id);
        return "the contact " + contactRepository.findById(id) + " was deleted";
    }

    @RequestMapping("/getallcontacts")
    public String printAllContacts(){
        List<Contact> contacts = contactService.getAllContacts();
        return contacts.toString();
    }
}
