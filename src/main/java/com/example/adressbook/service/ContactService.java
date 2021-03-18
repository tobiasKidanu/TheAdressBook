package com.example.adressbook.service;

import com.example.adressbook.entity.Contact;
import com.example.adressbook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Contact addContact(Contact contact) {
        Contact insert = contactRepository.insert(contact);
        return insert;
    }

    public void deleteContact() {
    }


    public List<Contact> getAllContact() {
        return contactRepository.findAll();
    }
}
