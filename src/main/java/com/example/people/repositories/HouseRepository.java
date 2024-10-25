package com.example.people.repositories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import com.example.people.entity.House;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.example.people.entity.House;
import com.example.people.services.HouseServices;
import com.example.people.controllers.HouseController;

import java.util.List;

public interface HouseRepository extends CrudRepository<House,Integer>, PagingAndSortingRepository<House,Integer> {



    public List<House> findByGrade(char grade);
    public List<House> findByPrice(double price);
}
