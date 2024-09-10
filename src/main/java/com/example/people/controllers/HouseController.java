package com.example.people.controllers;

import java.lang.Iterable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.people.entity.House;
import com.example.people.repositories.HouseRepository;

import org.springframework.web.bind.annotation.*;

@RestController
public class HouseController {
    private final HouseRepository houseRepository;

    public HouseController(final HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }


    @GetMapping("/house/search")
    public List<House> searchHouse(@RequestParam(name = "Grade" , required = false)char grade,
            @RequestParam(name = "Price" ,required = false)double Maxprice){
        if (grade  != 0){
            return this.houseRepository.findByGrade(grade);
        } else if (Maxprice != 0) {
            return this.houseRepository.findByPrice(Maxprice);
        } else{
            return new ArrayList<>();
        }

    }

    @GetMapping("/house")
    public Iterable getHouseDetails() {
        return this.houseRepository.findAll();

    }

    @GetMapping("/house/{id}")
    public Optional getHouseById(@PathVariable("id") Integer id) {
        return this.houseRepository.findById(id);

    }

    @PostMapping ("/house")
    public House createANewName(@RequestBody House house) {
        return houseRepository.save(house);

    }



    @PutMapping("/house/{id}")
    public House updateTheHouse(@PathVariable("id") Integer id, @RequestBody House h) {
        Optional<House> updateTheHouseOptional = this.houseRepository.findById(id);

        if (!updateTheHouseOptional.isPresent()) {
            return null;

        }
        House houseToUpdate = updateTheHouseOptional.get();

        if (h.getHouseLocation() != null) {
            houseToUpdate.setHouseLocation(h.getHouseLocation());
            {
                houseToUpdate.setExportAccess();

                if (h.getPrice() != 0) {
                    houseToUpdate.setPrice(h.getPrice());
                }

                House updateTheHouse = this.houseRepository.save(houseToUpdate);
                return updateTheHouse;
            }

        }

        return houseToUpdate;
    }
    @DeleteMapping("/house/{id}")
    public Boolean deletingAHouse (@PathVariable ("id") Integer id ){
        Optional <House> deletingAHouseOptional = this.houseRepository.findById(id);

        if (!deletingAHouseOptional.isPresent()){
            return false;
        }else{
            this.houseRepository.deleteById(id);
            return true;
        }
    }
}