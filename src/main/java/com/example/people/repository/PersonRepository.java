package com.example.people.repository;


import com.example.people.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CrudRepository <Person,Integer> {
    Optional findById();

    Person save();

    List<Person> findByRollNo(int rollNo);
    List<Person> findByName (String name);
    List <Person> findByRollNoAndName (int rollNo , String name);
}
