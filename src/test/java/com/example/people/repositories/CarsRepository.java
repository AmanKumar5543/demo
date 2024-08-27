package com.example.people.repositories;
import org.springframework.data.repository.CrudRepository;
import com.example.people.entity.Cars;

import java.util.List;
import java.util.Optional;

public interface CarsRepository extends CrudRepository <Cars ,Integer>{
  List<Cars> findByModel(String carModel);
}
