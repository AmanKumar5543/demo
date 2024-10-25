package com.example.people.controllers;

import java.lang.Iterable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.people.entity.House;
import com.example.people.repositories.HouseRepository;

import com.example.people.services.HouseServices;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
public class HouseController {
    private final HouseRepository houseRepository;

    public HouseController(final HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }
    @GetMapping("/house")
    public Iterable getAllHouse() {
        return this.houseRepository.findAll();

    }
    @GetMapping("/house/{id}")
    public Optional getHouseById(@PathVariable("id") Integer id) {
        return this.houseRepository.findById(id);

    }

    @GetMapping("/house/grade/{grade}")
    public List<House> getHouseByGrade(@PathVariable ("grade") char grade){
        return this.houseRepository.findByGrade(grade);
    }

    @GetMapping("/house/price/{price}")
    public List<House> getHouseByPrice(@PathVariable ("price") double price){
        return this.houseRepository.findByPrice(price);
    }


    @PostMapping ("/house")
    public House createNewHouse(@RequestBody House house) {
        return this.houseRepository.save(house);

    }
    @PutMapping("/house/{id}")
    public House updateHouse(@PathVariable("id") Integer id, @RequestBody House h) {
        Optional<House> updateTheHouseOptional = this.houseRepository.findById(id);

        if (!updateTheHouseOptional.isPresent()) {
            return null;
        }
        House houseToUpdate = updateTheHouseOptional.get();

        if (h.getHouseLocation() != null) {
            houseToUpdate.setHouseLocation(h.getHouseLocation());
        }

        if (h.getPrice() != 0) {
            houseToUpdate.setPrice(h.getPrice());
        }
        if (h.getGrade() != 0){
            houseToUpdate.setGrade(h.getGrade());
        }

        House updateHouse = this.houseRepository.save(houseToUpdate);
        return updateHouse;

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

//    @GetMapping("/sort/{field}")
//    public List<House> sortingByField(@PathVariable String field){
//        return HouseServices.sortBySomeField(field);
//    }
//
//    @GetMapping("page/{offSet}/{pageSize}")
//    public Page<House> paginationProduct(@PathVariable int offSet ,@PathVariable int pageSize){
//        return HouseServices.byPagination(offSet,pageSize);
//    }
//
//    @GetMapping("page/{offSet}/{pageSize}/{field}")
//    public Page<House> byPageAndSort(@PathVariable int offSet ,@PathVariable int pageSize,@PathVariable String field){
//        return HouseServices.bothSortAndPage(offSet,pageSize,field);
//    }


}