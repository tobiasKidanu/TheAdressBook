package com.example.adressbook;

import com.example.adressbook.entity.Contact;
import com.example.adressbook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AdressbookApplication {


    public static void main(String[] args) {
        SpringApplication.run(AdressbookApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/delete").allowedOrigins("http://localhost:4200");
                registry.addMapping("/put").allowedOrigins("http://localhost:4200");
                registry.addMapping("/post").allowedOrigins("http://localhost:4200");
                registry.addMapping("/get").allowedOrigins("http://localhost:4200");
            }
        };
    }

}
