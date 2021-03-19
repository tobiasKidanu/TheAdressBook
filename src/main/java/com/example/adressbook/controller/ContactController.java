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
        return contactService.getAllContacts();
    }

    @PostMapping(value = "/create/{name}")
    public void addContact(@RequestParam String name) {
        contactService.addContactByName(name);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String delete(@RequestParam String id) {

        contactService.delete(id);
        return "the contact with id: " + id + " was deleted";
    }

    @RequestMapping("/getallcontacts")
    public String printAllContacts() {
        List<Contact> contacts = contactService.getAllContacts();
        return contacts.toString();
    }

    @RequestMapping("/request")
    public String testRequest(){
        return "Request mapping works";
    }

    @GetMapping("/get")
    public String testGet() {
        return "Get mapping works";
    }

    @PostMapping("/post")
    public String testPost() {
        return "Post mapping works";
    }

    @PutMapping("/put")
    public String testPut() {
        return "Put mapping works";
    }

}
