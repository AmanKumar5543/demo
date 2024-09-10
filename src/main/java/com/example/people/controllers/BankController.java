package com.example.people.controllers;

import com.example.people.entity.Bank;
import com.example.people.repositories.BankRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.lang.Iterable;
import java.util.ArrayList;

@RestController
public class BankController {
    private final BankRepository bankRepository;

    public BankController(final BankRepository bankRepository){
        this.bankRepository= bankRepository;

    }

    @GetMapping("/bank")
    public Iterable getAllBankInfo(){
        return this.bankRepository.findAll();
    }

    @GetMapping("/bank/{id}")
    public Optional getBankInfoById(@PathVariable ("id") Integer id){
        return this.bankRepository.findById(id);
    }

    @GetMapping ("/bank/search")
    public List<Bank> searchName (@RequestParam (name = "Name", required = false)String name){
        return this.bankRepository.findByName(name);
    }

    @PostMapping ("/bank")
    public Bank createANewAccount(@RequestBody Bank bank){
        Bank newbank = this.bankRepository.save(bank);
        return newbank;
    }

    @PutMapping ("bank/{id}")
    public Bank updateTheAccount(@PathVariable ("id") Integer id , @RequestBody Bank b){
        Optional<Bank>updateTheAccountOptional = this.bankRepository.findById(id);

        if (!updateTheAccountOptional.isPresent()){
            return null;
        }
        Bank newUpdate = updateTheAccountOptional.get();

        if (b.getName() != null){
            newUpdate.setName(b.getName());
        }

        if (b.getAddress() != null){
            newUpdate.setAddress(b.getAddress());
        }

        if (b.getAccountNo() != 0){
            newUpdate.setAccountNo(b.getAccountNo());
        }
        if (b.getBalance() != 0){
            newUpdate.setBalance(b.getBalance());
        }
        Bank updateTheAccount = this.bankRepository.save(newUpdate);
        return updateTheAccount;
    }

    @DeleteMapping ("cars/{id}")
    public boolean deleteAnAccount(@PathVariable ("id") Integer id){
        Optional <Bank> deleteTheAccountOptional = this.bankRepository.findById(id);

        if (!deleteTheAccountOptional.isPresent()){
            return false;
        }else {
            this.bankRepository.deleteById(id);
            return true;
        }
    }




}
