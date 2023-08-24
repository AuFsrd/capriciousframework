package com.capriciousframework;

import com.capriciousframework.models.Person;
import com.capriciousframework.services.example.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PoliteframeworkApplication implements CommandLineRunner {

    @Autowired
    PersonServiceImpl personService;

    public static void main(String[] args) {
        SpringApplication.run(PoliteframeworkApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        personService.save(new Person("Robert")).please();
        personService.compliment("Tu es très beau");
        personService.getAll().please().forEach(System.out::println);

    }
}
