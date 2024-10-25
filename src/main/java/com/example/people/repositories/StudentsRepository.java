package com.example.people.repositories;

//import com.example.people.entity.Bank;
import org.springframework.data.repository.CrudRepository;
import  com.example.people.entity.Students;
import  com.example.people.controllers.StudentsController;

import java.util.List;


public interface StudentsRepository extends CrudRepository<Students,Integer> {
            List <Students> findByRollNo (int rollNo);
            List <Students> findByName (String name);
}
