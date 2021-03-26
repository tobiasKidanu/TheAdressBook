package com.example.adressbook.controller;

import com.example.adressbook.entity.Contact;
import com.example.adressbook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/contacts")
@CrossOrigin(origins = "http://localhost:4200")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping(value = "")
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping(path = "/{id}")
    public String getCertainContact(@PathVariable String id) {
        return "The contact " + contactService.getContact(id).toString() + " is here";
    }

    @PostMapping(value = "")
    public Contact addContact(@RequestBody Contact contact) {
        return contactService.addContact(contact);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable String id) {
        try {
            contactService.delete(id);
        } catch (Exception e) {
            System.out.println("Ooops delete faild");
        }
    }

    @PutMapping("/{id}")
    public Contact updateExistingContact(@PathVariable String id, @RequestBody Contact contact) {
        return contactService.updateContact(id, contact);
    }
}
