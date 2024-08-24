package com.example.people;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;
import java.lang.Iterable;

@RestController
public class PersonController {
    private final PersonRepository personRepository;  // instance field

    public PersonController(final PersonRepository personRepository){    //Constructor
        this.personRepository = personRepository;
    }

    //Reading the repository by id or reading all at once
    @GetMapping ("/people")             // After this we only add methods
        public Iterable <Person> getAllPerson(){
        return this.personRepository.findAll();
    }

    @GetMapping("people/{id}")
        public Optional <Person> getPeopleById(@PathVariable("id") Integer id)
    {
        return this.personRepository.findById();
    }

    @PostMapping
        public Person createNewPerson(@RequestBody Person person) {
          Person newPerson = this.personRepository.save();
          return newPerson;
    }



}

