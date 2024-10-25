package com.example.people.controllers;

import com.example.people.entity.Students;
import com.example.people.repositories.StudentsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentsController {
    private final StudentsRepository studentsRepository;

    public StudentsController(final StudentsRepository studentsRepository, StudentsRepository studentsRepository1) {
        this.studentsRepository = studentsRepository1;

    }

    @GetMapping("/students")
    public Iterable getAllStudents() {
        return this.studentsRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public Optional getStudentsById(@PathVariable Integer id) {
        return this.studentsRepository.findById(id);
    }

    @GetMapping ("/students/search")
    public List <Students> searchByRoll (@RequestParam (name = "Roll_no" ,required = false) int rollNo){
        return this.studentsRepository.findByRollNo(rollNo);
    }

    @GetMapping ("/students/search/Name")
    public List <Students> searchByName (@RequestParam (name = "Name" , required = false) String name){
        return this.studentsRepository.findByName(name);
    }

    @PostMapping("/students")
    public Students createNewStudent(@RequestBody Students students) {
        Students newStudent = (Students) this.studentsRepository.save(students);
        return newStudent;
    }

    @PutMapping("/students/{id}")
    public Students updateStudent(@PathVariable Integer id, @RequestBody Students S) {
        Optional<Students> updateTheBankOptional = this.studentsRepository.findById(id);

        if (!updateTheBankOptional.isPresent()) {
            return null;
        }
        Students newUpdate = updateTheBankOptional.get();

        if (S.name != null) {
            newUpdate.setName(S.getName());
        }

        if (S.rollNo != 0) {
            newUpdate.setRollNo((S.getRollNo()));
        }

        if (S.student_address != null) {
            newUpdate.setStudent_address(S.getStudent_address());
        }
        Students updateStudent = (Students) this.studentsRepository.save(newUpdate);
        return updateStudent;

    }

    @DeleteMapping("/students/{id}")
    public Boolean deleteStudent(@PathVariable Integer id) {
        Optional<Students> deleteStudentOptional = this.studentsRepository.findById(id);

        if (!deleteStudentOptional.isPresent()) {
            return false;
        } else {
            this.studentsRepository.deleteById(id);
            return true;
        }


    }
}




