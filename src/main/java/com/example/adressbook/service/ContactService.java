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


    public List<Contact> getAllContact() {
        return contactRepository.findAll();
    }

    public Contact addContact(Contact contact) {
        Contact insertContact = contactRepository.insert(contact);
        return insertContact;
    }

    public void delete(String id){
        contactRepository.deleteById(id);
    }

}
