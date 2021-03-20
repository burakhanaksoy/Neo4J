package com.thebman.neo4jstudy.service;

import com.thebman.neo4jstudy.node.Employee;
import com.thebman.neo4jstudy.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee savePerson(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
}
