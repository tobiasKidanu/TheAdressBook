package com.example.adressbook.service;

import com.example.adressbook.entity.Contact;
import com.example.adressbook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public void addContact(Contact contact) {
        contactRepository.insert(contact);
    }

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public void delete(String id){
        contactRepository.deleteById(id);
    }

}
