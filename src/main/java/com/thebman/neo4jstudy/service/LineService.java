package com.thebman.neo4jstudy.service;

import com.thebman.neo4jstudy.node.Employee;
import com.thebman.neo4jstudy.node.Line;
import com.thebman.neo4jstudy.node.Project;
import com.thebman.neo4jstudy.repository.EmployeeRepository;
import com.thebman.neo4jstudy.repository.LineRepository;
import com.thebman.neo4jstudy.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class LineService {
    @Autowired
    private LineRepository lineRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public Line saveLine(Line line) {
        return lineRepository.save(line);
    }

    public Line findLine(String lineName) {
        return lineRepository.findByName(lineName);
    }

    public List<Line> getLines() {
        return lineRepository.findAll();
    }


    public void deleteLine(String lineId) {
        lineRepository.delete(findLine(lineId));
    }

    public Set<Project> getProjectsByLineId(String lineId) {
        Line line = lineRepository.findByName(lineId);
        return line.getProjectSet();
    }

    public void addProjectToLine(String lineId, Project project) {
        Line line = lineRepository.findByName(lineId);
        Set<Project> projectSet;
        if (line.getProjectSet() != null)
            projectSet = line.getProjectSet();
        else
            projectSet = new HashSet<>();
        projectSet.add(project);
        projectRepository.save(project);
        // Update project set
        line.setProjectSet(projectSet);
//        lineRepository.save(new Line(lineId,projectSet));
        lineRepository.save(line);

//        System.out.println(line.getProjectSet().toString());
    }

    public Project getProjectByLineId(String lineId, String projectId) {
        Line line = lineRepository.findByName(lineId);
        return line.getProjectSet().stream().
                filter(project -> project.getName().equals(projectId)).findAny().orElse(new Project());
    }

    public Set<Employee> getEmployeesByProjectName(String lineId, String projectId) {
        Project project = getProjectByLineId(lineId, projectId);
        return project.getEmployee();
    }

    public void addEmployeesByProjectName(String lineId, String projectId, Employee employee) {
        Line line = findLine(lineId);
        Project project = line.getProjectSet().stream().
                filter(p -> p.getName().equals(projectId)).findAny().orElse(new Project());
        Employee newEmployee = new Employee(employee.getName(), employee.getAge(), project.getName());
//        employeeRepository.save(newEmployee);
        Set<Employee> tempSet;
        if (project.getEmployee() != null)
            tempSet = project.getEmployee();
        else
            tempSet = new HashSet<>();
        tempSet.add(newEmployee);
        project.setEmployee(tempSet);
        employeeRepository.save(newEmployee);
        projectRepository.save(project);
    }
}
