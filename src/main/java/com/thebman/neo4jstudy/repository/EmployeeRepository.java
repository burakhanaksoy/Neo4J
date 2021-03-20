package com.thebman.neo4jstudy.repository;

import com.thebman.neo4jstudy.node.Employee;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends Neo4jRepository<Employee, Long> {
//    public List<Employee> getEmployeesByProject(String project_name);
}
