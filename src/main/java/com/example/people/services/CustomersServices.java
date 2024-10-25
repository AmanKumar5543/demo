package com.example.people.services;

import com.example.people.entity.Customers;
import com.example.people.entity.House;
import com.example.people.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CustomersServices {

    @Autowired
    private static CustomersRepository customersRepository;

    public Iterable<Customers> findAllCustomers (){
        return customersRepository.findAll();
    }

    public Optional<Customers> findCustomersById (int id){
        return customersRepository.findById(id);
    }

    public static List<Customers> sortBySomeField(String field){
        return (List<Customers>) customersRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    public static Page<Customers> pagination(int offSet, int pageSize){
        return (Page<Customers>) customersRepository.findAll(PageRequest.of(offSet,pageSize));
    }

    public static Page<Customers> sortAndPage (int offSet , int pageSize,String field){
        return (Page<Customers>) customersRepository.findAll(PageRequest.of(offSet,pageSize).withSort(Sort.Direction.ASC,field));
    }

    public Customers createCustomers (Customers customers){
        return customersRepository.save(customers);
    }

    public Customers updateTheHouse(@PathVariable int id , @RequestBody Customers c){
        return customersRepository.save(c);
    }

    public boolean deleteTheCustomers (@PathVariable int id){
        customersRepository.deleteById(id);
        return true;
    }
}
