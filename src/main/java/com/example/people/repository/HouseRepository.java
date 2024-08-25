package com.example.people.repository;
import org.springframework.data.repository.CrudRepository;
import com.example.people.entity.House;

import java.util.List;
import java.util.Optional;

public interface HouseRepository extends CrudRepository<House,Integer>{





    List<House> findByGrade(char grade);
    List<House> findByPrice(double price);
}
