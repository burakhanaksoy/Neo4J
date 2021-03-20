package com.thebman.neo4jstudy.service;

import com.thebman.neo4jstudy.node.Employee;
import com.thebman.neo4jstudy.node.Project;
import com.thebman.neo4jstudy.repository.EmployeeRepository;
import com.thebman.neo4jstudy.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    public void deleteProject(String projectName) {
        projectRepository.delete(findProject(projectName));
    }

    public Project findProject(String projectName) {
        return projectRepository.findByName(projectName);
    }

    public List<Employee> getEmployee(String project_name){
        Set<Employee> employeeSet;
//        return personRepository.getEmployeesByProject(project_name);
        return null;
    }



}
