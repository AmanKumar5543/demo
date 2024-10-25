package com.example.people.services;

import com.example.people.entity.Employee;
import com.example.people.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.people.controllers.EmployeeController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices {


    private static EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeServices(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public Iterable<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findEmployeeById(@PathVariable("id") Integer id) {
        return employeeRepository.findById(id);
    }

    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee e) {
        return employeeRepository.save(e);
    }

    public Boolean deleteEmployee(@PathVariable("id") Integer id) {
        employeeRepository.deleteById(id);
        return true;
    }
    public List getEmployeeByName (@PathVariable ("name") String name){
        return  employeeRepository.findByName(name);
    }

    public List getEmployeeByDepartment(@PathVariable ("department") String department){
        return  this.employeeRepository.findByDepartment(department);
    }

    public List getEmployeeBySalary (@PathVariable ("salary") Integer salary){
        return this.employeeRepository.findBySalary(salary);
    }
    public Page<Employee> findByPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return employeeRepository.findAll(pageable);
    }
}

