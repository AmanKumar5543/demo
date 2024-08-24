package com.example.people.repository;


import com.example.people.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonRepository extends CrudRepository <Person,Integer> {
    Optional findById();

    Person save();
}
