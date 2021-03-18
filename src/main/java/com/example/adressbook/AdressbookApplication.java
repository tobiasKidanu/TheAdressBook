package com.example.adressbook;

import com.example.adressbook.entity.Contact;
import com.example.adressbook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdressbookApplication {

    @Autowired
    private ContactRepository contactRepository;

    public static void main(String[] args) {
        SpringApplication.run(AdressbookApplication.class, args);
    }


    public void run(String... args) throws Exception {
        Contact one = new Contact(1, "Tobias", "Gatan");
        Contact two = new Contact(2, "erik", "Gatan");
        Contact three = new Contact(3, "daniel", "Gatan");

        contactRepository.save(one);
        contactRepository.save(two);
        contactRepository.save(three);
    }
}
