package com.capriciousframework.repositories;

import com.capriciousframework.models.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends GenericRepository<Person> {
}
