package com.capriciousframework;

import com.capriciousframework.models.Person;
import com.capriciousframework.services.example.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CapriciousFrameworkApplication implements CommandLineRunner {

    @Autowired
    PersonServiceImpl personService;

    public static void main(String[] args) {
        SpringApplication.run(CapriciousFrameworkApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        personService.couldyou().save(new Person("Robert")).please();
        personService.thankyou();

        personService.couldyou().save(new Person("Bobby")).please();
        personService.thankyou();

        personService.couldyou().save(new Person("Jojo")).please();
        personService.thankyou();

        personService.couldyou().delete(personService.couldyou().getById(1).please());

        personService.couldyou().getAll().please().forEach(System.out::println);

        personService.compliment("Tu fais du très bon travail");

    }
}
