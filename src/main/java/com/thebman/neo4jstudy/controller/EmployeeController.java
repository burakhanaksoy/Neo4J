package com.thebman.neo4jstudy.controller;

import com.thebman.neo4jstudy.repository.EmployeeRepository;
import com.thebman.neo4jstudy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/company/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    ResponseEntity getEmployees(){
        return new ResponseEntity(employeeService.getEmployees(), HttpStatus.OK);
    }
}
