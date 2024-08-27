package com.example.people.controllers;

import com.example.people.entity.Cars;
import com.example.people.repositories.CarsRepository;
import org.checkerframework.checker.units.qual.C;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CarsController{
    private final CarsRepository carsRepository;

    public CarsController(final CarsRepository carsRepository){
        this.carsRepository = carsRepository;
    }

    @GetMapping("/cars")
    public Iterable findAllCars (){
        return this.carsRepository.findAll();
    }

    @GetMapping("/cars/{id}")
    public Optional findCarsById (@PathVariable ("id") Integer id){
        return this.carsRepository.findById(id);
    }

    @PostMapping("/cars")
    public Cars createACar(@RequestBody Cars cars){
        Cars newCar = this.carsRepository.save(cars);
        return newCar;
    }

    @PostMapping("/cars/{id}")
    public Cars updateCars (@PathVariable ("id") Integer id , @RequestBody Cars c){
        Optional <Cars> updateCarsOptional = this.carsRepository.findById(id);

        if (!updateCarsOptional.isPresent()){
            return null;
        }
        Cars newUpdate = updateCarsOptional.get();

        if (c.getCarModel() != null){
            newUpdate.setCarModel(c.getCarModel());
        }
        if (c.getPrice() != 0){
            newUpdate.setPrice(c.getPrice());
        }
        if (c.getHorsePower() != 0){
            newUpdate.setHorsePower(c.getHorsePower());
        }
        if (c.getGrade() != 0){
            newUpdate.setGrade(c.getGrade());
        }
        Cars updateCars = this.carsRepository.save(newUpdate);
        return  updateCars;
    }

    @DeleteMapping("/cars/{id}")
    public boolean deleteCars (@PathVariable ("id") Integer id){
        Optional <Cars> deleteById = this.carsRepository.findById(id);

        if (deleteById != null){
            this.carsRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

}