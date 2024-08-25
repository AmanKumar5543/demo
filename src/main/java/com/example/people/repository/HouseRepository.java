package com.example.people.repository;
import org.springframework.data.repository.CrudRepository;
import com.example.people.entity.House;

import java.util.Optional;

public interface HouseRepository extends CrudRepository<House,Integer>{
    Optional findAllById();

    House save();

    Optional delete(Integer id);

    void delete();
}
