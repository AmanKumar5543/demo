package com.example.people.controllers;

import com.example.people.entity.Customers;
import com.example.people.repositories.CustomersRepository;
import com.example.people.services.CustomersServices;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomersController {

    private final CustomersRepository customersRepository;

    public CustomersController (final CustomersRepository customersRepository){  // make cunstructor
        this.customersRepository = customersRepository;
    }

    @GetMapping ("/customers")
    public Iterable<Customers> findAllCustomers (){
        return customersRepository.findAll();
    }

    @GetMapping ("/customers/{id}")
    public Optional<Customers> findCustomersById (@PathVariable int id){
        return customersRepository.findById(id);
    }

    @GetMapping ("customers/sort/{field}")
    public List<Customers> sortField (@PathVariable String field){
        return CustomersServices.sortBySomeField(field);
    }

    @GetMapping ("customers/{offSet}/{pageSize}")
    public Page<Customers> paginate (@PathVariable int offSet , @PathVariable int pageSize){
        return CustomersServices.pagination(offSet,pageSize);
    }

    @GetMapping ("customers/sort/{offSet}/{pageSize}/{field}")
    public Page<Customers> sortingAndPaginate(@PathVariable String field , @PathVariable int offSet, @PathVariable int pageSize){
        return  CustomersServices.sortAndPage(offSet,pageSize,field);
    }

    @PostMapping ("/customers")
    public Customers createCustomer (@RequestBody Customers customers){
        return (Customers) customersRepository.save(customers);
    }

    @PutMapping("/customers/{id}")
    public Customers updateCustomers (@PathVariable int id , @RequestBody Customers c) {
        Optional<Customers> updateById = this.customersRepository.findById(id);
        if (updateById.isEmpty()) {
            return null;
        }
        Customers customersUpdate = updateById.get();

        if (c.getName() != null) {
            customersUpdate.setName(c.getName());}

            if (c.getAddress() != null) {
                customersUpdate.setAddress((c.getAddress()));
            }
            Customers updateCustomer = (Customers) this.customersRepository.save(customersUpdate);
            return updateCustomer;
        }

        @DeleteMapping("/customers/{id}")
    public boolean deleteCustomers (@PathVariable int id){
        Optional<Customers> deleteByCustId =this.customersRepository.findById(id);
        if (deleteByCustId.isPresent()){
            customersRepository.deleteById(id);
            return true;
        }return false;
    }




}
