package com.example.people.repositories;
import com.example.people.entity.Cars;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarsRepository extends CrudRepository <Cars ,Integer>{
  List<Cars> findByCarModel (String carModal);
  List<Cars> findByGrade (char grade);
  List<Cars> findByCarModelAndGrade (String carModel , char grade);
}
