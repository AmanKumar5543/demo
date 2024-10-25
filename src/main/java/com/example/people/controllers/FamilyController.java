package com.example.people.controllers;

import com.example.people.entity.Family;
import com.example.people.repositories.FamilyRepository;
import jakarta.persistence.Id;
import org.springframework.web.bind.annotation.*;

import java.lang.Iterable;
import java.util.Optional;


@RestController
public class FamilyController {
    private final FamilyRepository familyRepository;

    public FamilyController (final FamilyRepository familyRepository){
        this.familyRepository = familyRepository;
    }

    @GetMapping("/family")
    public Iterable<Family> getFamily(){
        return this.familyRepository.findAll();
    }

    @GetMapping ("/family/{id}")
    public Optional<Family> getFamilyById (@PathVariable ("id") Integer id){
        return this.familyRepository.findById(id);
    }

    @PostMapping ("/family")
        public Family creatreFamily (@RequestBody Family family){
        Family newFamily = (Family) this.familyRepository.save(family);
        return newFamily;
        }
    @PutMapping("/family/{id}")
    public Family updateFamily (@PathVariable ("id") Integer id ,@RequestBody Family fam){
         Optional <Family>updateFamilyById = this.familyRepository.findById(id);

         if (!updateFamilyById.isPresent() ){
             return null;
         }

         Family familyToUpdate = updateFamilyById.get();

         if (fam.getName() != null){
             familyToUpdate.setName(fam.getName());
         }

         if (fam.getDesignation() != null){
             familyToUpdate.setDesignation(fam.getDesignation());
         }

         if (fam.getAge() != 0){
             familyToUpdate.setAge(fam.getAge());
         }

         if (fam.getRole() != null){
             familyToUpdate.setRole(fam.getRole());
         }

        Family updateFamily = (Family) this.familyRepository.save(familyToUpdate);
         return  updateFamily;

    }

    @DeleteMapping ("/family/{id}")
     public boolean deleteMember (@PathVariable ("id") Integer id){
        Optional<Family> deleteByID = this.familyRepository.findById(id);

        if (!deleteByID.isPresent()){
            return false;
        }else {
            this.familyRepository.deleteById(id);
            return true;
        }
     }



}

