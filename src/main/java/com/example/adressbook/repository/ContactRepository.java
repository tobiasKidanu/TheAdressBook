package com.example.adressbook.repository;
import com.example.adressbook.entity.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<Contact, Long> {
}
