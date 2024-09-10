package com.example.people.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.people.entity.Family;
import org.springframework.data.repository.CrudRepository;
import com.example.people.controllers.FamilyController;

public interface FamilyRepository extends CrudRepository<Family,Integer> {
}
