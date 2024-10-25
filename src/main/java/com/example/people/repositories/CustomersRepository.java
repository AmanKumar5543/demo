package com.example.people.repositories;
import com .example.people.entity.Customers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface CustomersRepository extends PagingAndSortingRepository <Customers,Integer> ,CrudRepository<Customers,Integer>, JpaRepository<Customers,Integer> {





}
