package com.example.adressbook.controller;

import com.example.adressbook.entity.Contact;
import com.example.adressbook.repository.ContactRepository;
import com.example.adressbook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping(value = "/all")
    //@CrossOrigin(origins = "http://localhost:4200")
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

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        try {
            contactService.delete(id);
        } catch (Exception e) {
            System.out.println("Ooops delete faild");
        } 
    }

    @RequestMapping("/getallcontacts")
    public String printAllContacts() {
        List<Contact> contacts = contactService.getAllContacts();
        return contacts.toString();
    }

    @RequestMapping("/request")
    public String testRequest(){
        System.out.println("Reques mapping reached");
        return "request mapping works";
    }
    //@CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/get")
    public String testGet() {
        System.out.println("Get mapping reached");
        return "get mapping works";
    }
    //@CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/post")
    public void testPost() {
        System.out.println("Post mapping reached");
    }
    //@CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/put")
    public void testPut() {
        System.out.println("Put mapping reached");
    }
    //@CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/delete")
    public void testDelete() {
        System.out.println("Delete mapping reached");
    }

}
