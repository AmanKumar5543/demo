package com.example.people.services;

import com.example.people.repositories.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentsServices
{
    @Autowired
    private StudentsRepository studentsRepository;

    public Iterable getAllStudents (){
        return this.studentsRepository.findAll();
    }

    public Optional getStudentsById(int id){
        return this.studentsRepository.findById(id);
    }
}
