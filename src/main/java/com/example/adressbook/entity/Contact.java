package com.example.adressbook.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("contacts")
public class Contact {

    @Id
    public String id;
    public String name;
    public String adress;

    public Contact(String name, String adress) {
        this.name = name;
        this.adress = adress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString(){
        return this.name + " lives at " + this.adress; 
    }
}
