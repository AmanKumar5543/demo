package com.example.people.repositories;

import com.example.people.entity.Bank;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BankRepository extends CrudRepository<Bank,Integer> {

    List<Bank> findByName (String name);
}

