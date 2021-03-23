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


    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Contact addContact(Contact contact) {
        Contact insertContact = contactRepository.insert(contact);
        contactRepository.save(contact);
        return insertContact;
    }

    public void delete(String id){
        contactRepository.deleteById(id);
    }

    public Contact updateContact(String id, Contact newContactInformation) {
        Contact contact = getContact(id);
        contact.setName(newContactInformation.getName());
        contact.setAdress(newContactInformation.getAdress());
        contactRepository.save(contact);
        return contact;
    }

    public Contact getContact(String id) {
        Optional<Contact> byId = contactRepository.findById(id);
        Contact contact = byId.get();
        return contact;
    }
}
