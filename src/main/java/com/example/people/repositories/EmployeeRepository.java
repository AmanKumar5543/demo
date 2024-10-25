package com.example.people.repositories;
import com.example.people.entity.Employee;
import com.example.people.controllers.EmployeeController;
import com.example.people.services.EmployeeServices;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;


public interface EmployeeRepository extends CrudRepository<Employee,Integer>, JpaRepository<Employee,Integer>, PagingAndSortingRepository<Employee,Integer> {

    public List<Employee> findByName(String name);
    public List<Employee> findBySalary(Integer salary);
    public List<Employee> findByDepartment(String department);

 }
