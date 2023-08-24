package com.capriciousframework.services.example;

import com.capriciousframework.models.Person;
import com.capriciousframework.services.CapriciousServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends CapriciousServiceImpl<Person> implements PersonService {
}
