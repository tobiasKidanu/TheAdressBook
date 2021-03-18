package com.example.adressbook.service;

import com.example.adressbook.entity.Contact;
import com.example.adressbook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public void addContact(Contact contact) {
        contactRepository.insert(contact);
    }

    public void deleteContact() {
    }

    public void updateContact() {
    }

    public void getAllContact() {

    }
}
