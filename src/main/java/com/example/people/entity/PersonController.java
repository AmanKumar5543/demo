package com.example.people.entity;
import java.lang.Iterable;
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


