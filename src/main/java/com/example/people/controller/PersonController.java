package com.example.people.controller;

import java.lang.Iterable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.people.repository.PersonRepository;
import com.example.people.entity.Person;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
//    Querry Breathing First form
//    @GetMapping("/people/search")
//    public List<Person> searchPeople (@RequestParam (name ="RollNo",required = false)int rollNo){
//        if (rollNo != 0){
//            return this.personRepository.findByRollNo(rollNo);
//        }else{
//            return new ArrayList<>();
//        }
//

//    Querry breathing second form
//    @GetMapping("/people/search")
//    public List<Person> searchPeople (@RequestParam(name = "Roll no" ,required = false)int rollNo,
//                                      @RequestParam(name = "Name" ,required = false)String name){
//        if (rollNo !=0){
//            return this.personRepository.findByRollNo(rollNo);
//        } else if (name != null) {
//            return this.personRepository.findByName(name);
//        }else {
//            return new ArrayList<>();
//        }

//    Querry breathing third form
@GetMapping("/people/search")
public List<Person> searchPeople (@RequestParam(name = "Roll no" ,required = false)int rollNo,
                                  @RequestParam(name = "Name" ,required = false)String name){
    if (rollNo !=0 && name != null ) {
        return this.personRepository.findByRollNoAndName(rollNo, name);
    } else if (rollNo != 0) {
        return this.personRepository.findByRollNo(rollNo);
    } else if (name != null) {
        return this.personRepository.findByName(name);
    }else {
        return new ArrayList<>();
    }



    }
    @GetMapping("/people")
    public Iterable<Person> getAllNames() {
        return this.personRepository.findAll();
    }

    @GetMapping("/people/{id}")
    public Optional getById(@PathVariable("id") Integer id) {
        return this.personRepository.findById();
    }

    @PostMapping
    public Person createNewName(@RequestBody Person person) {
        Person newPerson = this.personRepository.save();
        return newPerson;
    }

    //    @PutMapping("people/{id}")
//    public Person updatePerson(@PathVariable("id") Integer id, @RequestBody Person p) {
//
//        Optional<Person> personToUpdateOptional = this.personRepository.findById(id);
//
//        if (!personToUpdateOptional.isPresent()) {
//            return null;
//        }
//
//        Person personToUpdate = personToUpdateOptional.get();
//
//        if (p.getName() != null) {
//            personToUpdate.setName(p.getName());
//        }
//
//            if (p.getRollNo() != 0) {
//                personToUpdate.setRollNo(p.getRollNo());
//            }
//
//            if (p.getInfo() != null) {
//                personToUpdate.setInfo(p.setInfo());
//                }
//
//                Person newUpdate = this.personRepository.save(personToUpdate);
//                return newUpdate;
//            }
//        }
//
    @PutMapping("/people/{id}")
    public Person updatePerson(@PathVariable("id") Integer id, @RequestBody Person p) {
        Optional<Person> personToUpdateOptional = this.personRepository.findById(id);
        if (!personToUpdateOptional.isPresent()) {
            return null;
        }

        // Since isPresent() was true, we can .get() the Person object out of the Optional
        Person personToUpdate = personToUpdateOptional.get();

        if (p.getName() != null) {
            personToUpdate.setName(p.getName());
        }
        if (p.getRollNo() != 0) {
            personToUpdate.setRollNo(p.getRollNo());
        }
        if (p.getInfo() != null) {
            personToUpdate.setInfo(p.getInfo());
        }

        Person updatedPerson = this.personRepository.save(personToUpdate);
        return updatedPerson;
    }
    @DeleteMapping("people/{id}")
    public Person personTODelete (@PathVariable("id") Integer id , @RequestBody Person p ) {
        Optional<Person> personToDeleteOptional = this.personRepository.findById();

        if (!personToDeleteOptional.isPresent()) {
            return null;
        }

        Person personToDelete = personToDeleteOptional.get();
        this.personRepository.delete(personToDelete);
        return personToDelete;
    }
}


