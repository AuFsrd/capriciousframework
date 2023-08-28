package com.capriciousframework;

import com.capriciousframework.models.Person;
import com.capriciousframework.services.example.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class CapriciousFrameworkApplication implements CommandLineRunner {

    @Autowired
    PersonServiceImpl personService;

    public static void main(String[] args) {
        SpringApplication.run(CapriciousFrameworkApplication.class, args);
    }

    @Override
    public void run(String... args) {

        if (LocalDateTime.now().getHour() < 12) {
            personService.goodMorning();
        } else if (LocalDateTime.now().getHour() >= 18 ) {
            personService.goodEvening();
        } else {
            personService.goodAfternoon();
        }

        personService.couldYou().save(new Person("Robert")).please();
        personService.thankYou();

        personService.couldYou().save(new Person("Bobby")).please();
        personService.thankYou();

        personService.couldYou().save(new Person("Jojo")).please();
        personService.thankYou();

        personService.couldYou().delete(personService.couldYou().getById(1).please());

        personService.couldYou().getAll().please().forEach(System.out::println);

        personService.compliment("Tu fais du très bon travail");

    }
}
