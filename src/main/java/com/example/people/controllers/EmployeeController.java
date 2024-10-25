package com.example.people.controllers;

import com.example.people.entity.Employee;
import com.example.people.entity.House;
import com.example.people.repositories.EmployeeRepository;
import com.example.people.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {


    private final EmployeeServices employeeServices;

    @Autowired
    public EmployeeController(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }


    @GetMapping("/employee")
    public Iterable getAllEmployee (){
        return this.employeeServices.findAllEmployee();
    }
    @GetMapping("/employee/{id}")
    public Optional getEmployeeById (@PathVariable ("id") Integer id){
        return this.employeeServices.findEmployeeById(id);
    }
    @GetMapping("/employee/name/{name}")
    public List getEmployeeByName (@PathVariable ("name") String name){
        return  this.employeeServices.getEmployeeByName(name);
    }
    @GetMapping ("/employee/dept/{department}")
    public List getEmployeeByDepartment(@PathVariable ("department") String department){
        return  this.employeeServices.getEmployeeByDepartment(department);
    }

    @GetMapping ("/employee/salary/{salary}")
    public List getEmployeeBySalary (@PathVariable ("salary") Integer salary){
        return this.employeeServices.getEmployeeBySalary(salary);
    }

    @GetMapping("/employees")
    public Page<Employee> getEmployees (
            @RequestParam(defaultValue = "0") int page,  // default to the first page
            @RequestParam(defaultValue = "5") int size
    ) {
         return this.employeeServices.findByPage(page, size);

    }
    @PostMapping("/employee")
    public Employee createEmployee (@RequestBody Employee employee){
        return this.employeeServices.createEmployee(employee);
    }
    @PutMapping("/employee/{id}")
    public Employee updateEmployee (@PathVariable ("id") Integer id , @RequestBody Employee e){
        Optional<Employee> updateEmployeeById = this.employeeServices.findEmployeeById(id);

        if (!updateEmployeeById.isPresent()){
            return null;
        } Employee newUpdate = updateEmployeeById.get();

        if (e.getName() != null){
            newUpdate.setName(e.getName());
        }
        if (e.getDepartment() != null){
            newUpdate.setDepartment(e.getDepartment());
        }
        if(e.getSalary() != 0){
            newUpdate.setSalary(e.getSalary());
        }
        Employee updateEmployee =this.employeeServices.createEmployee(newUpdate);
        return updateEmployee;
    }
    @DeleteMapping("/employee/{id}")
    public boolean deleteEmployee (@PathVariable ("id") Integer id){
        Optional<Employee> deleteById = this.employeeServices.findEmployeeById(id);

        if(deleteById.isPresent()){
            this.employeeServices.deleteEmployee(id);
            return true;
        }return false;
    }

}