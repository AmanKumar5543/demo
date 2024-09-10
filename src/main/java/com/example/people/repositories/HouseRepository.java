package com.example.people.repositories;
import org.springframework.data.repository.CrudRepository;
import com.example.people.entity.House;

import java.util.List;

public interface HouseRepository extends CrudRepository<House,Integer>{





    List<House> findByGrade(char grade);
    List<House> findByPrice(double price);
}
