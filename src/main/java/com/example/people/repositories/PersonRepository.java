package com.example.people.repositories;


import com.example.people.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository <Person,Integer> {



    List<Person> findByRollNo(int rollNo);
    List<Person> findByName (String name);
    List <Person> findByRollNoAndName (int rollNo , String name);
}
