package com.example.people.services;

import com.example.people.entity.House;
import com.example.people.repositories.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.people.controllers.HouseController;

import java.util.List;
import java.util.Optional;

@Service
public class HouseServices {

    @Autowired
    private static HouseRepository houseRepository;

    public Iterable<House> getAllHouseDetails (){
        return houseRepository.findAll();
    }

    public Optional<House> getHouseByID (int id){
        return houseRepository.findById(id);
    }

    public List<House> getHouseByGrade(@PathVariable ("grade") char grade){
        return  houseRepository.findByGrade(grade);
    }
    public List<House> getHouseByGrade(@PathVariable ("price") double price) {
        return houseRepository.findByPrice(price);
    }
    public House createANewName (House name){
        return houseRepository.save(name);
    }

    public  House updateTheHouse(@PathVariable int id , @RequestBody House h){
        return houseRepository.save(h);
    }

    public boolean deleteTheHouse (@PathVariable int id){
        houseRepository.deleteById(id);
        return true;
    }

//    public static List<House> sortBySomeField(String field){
//        return HouseRepository.findAll(Sort.by(Sort.Direction.ASC,field));
//    }
//
//    public static Page<House> byPagination(int offSet, int pageSize){
//        return HouseRepository.findAll(PageRequest.of (offSet,pageSize));
//    }
//
//    public static Page<House> bothSortAndPage (int offSet, int pageSize, String field){
//        return HouseRepository.findAll(PageRequest.of(offSet,pageSize).withSort(Sort.by(Sort.Direction.ASC,field)));
//    }
//
//

}
