package com.thebman.neo4jstudy.controller;

import com.thebman.neo4jstudy.node.Employee;
import com.thebman.neo4jstudy.node.Line;
import com.thebman.neo4jstudy.node.Project;
import com.thebman.neo4jstudy.service.LineService;
import com.thebman.neo4jstudy.service.ProjectService;
import com.thebman.neo4jstudy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/company/lines")
public class LineController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private LineService lineService;

    @PostMapping
    ResponseEntity saveLine(@RequestBody Line line) {
        return new ResponseEntity(lineService.saveLine(line), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity getLines() {
        return new ResponseEntity(lineService.getLines(), HttpStatus.OK);
    }

    @GetMapping("/{lineId}")
    ResponseEntity getLine(@PathVariable String lineId) {
        return new ResponseEntity(lineService.findLine(lineId), HttpStatus.OK);
    }

    @DeleteMapping("/{lineId}")
    ResponseEntity deleteLine(@PathVariable String lineId) {
        lineService.deleteLine(lineId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{lineId}/projects")
    ResponseEntity getProjectsByLineId(@PathVariable String lineId) {
        return new ResponseEntity(lineService.getProjectsByLineId(lineId), HttpStatus.OK);
    }

    @PostMapping("/{lineId}/projects")
    ResponseEntity addProjectToLine(@PathVariable String lineId, @RequestBody Project project) {
        lineService.addProjectToLine(lineId, project);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{lineId}/projects/{projectId}")
    ResponseEntity getProjectByLineId(@PathVariable String lineId, @PathVariable String projectId) {
        return new ResponseEntity(lineService.getProjectByLineId(lineId, projectId), HttpStatus.OK);
    }

    @GetMapping("/{lineId}/projects/{projectId}/employees")
    ResponseEntity getEmployeesByProjectName(@PathVariable String lineId, @PathVariable String projectId) {
        return new ResponseEntity(lineService.getEmployeesByProjectName(lineId, projectId), HttpStatus.OK);
    }

    @PostMapping("/{lineId}/projects/{projectId}/employees")
    ResponseEntity addEmployeesByProjectName(@PathVariable String lineId, @PathVariable String projectId
            , @RequestBody Employee employee) {

        lineService.addEmployeesByProjectName(lineId,projectId,employee);

        return new ResponseEntity(HttpStatus.CREATED);
    }



//    @GetMapping("/line/projects")
//    ResponseEntity getProjects() {
//        return new ResponseEntity(projectService.getProjects(), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/line/projects/{project_name}")
//    ResponseEntity deleteProject(@PathVariable String project_name) {
//        projectService.deleteProject(project_name);
//        return new ResponseEntity(HttpStatus.OK);
//    }
//
//    @GetMapping("/line/projects/{project_name}/employee")
//    ResponseEntity getEmployee(@PathVariable String project_name) {
//
//        return new ResponseEntity(projectService.getEmployee(project_name), HttpStatus.CREATED);
//    }
//
//    @PostMapping("/line/projects/{project_name}/employee")
//    ResponseEntity saveEmployee(@RequestBody Employee employee) {
//
//        return new ResponseEntity(personService.savePerson(employee), HttpStatus.CREATED);
//    }
//
//    @PostMapping("/line")
//    ResponseEntity saveLine(@RequestBody Line line) {
//        return new ResponseEntity( lineService.saveLine(line), HttpStatus.CREATED);
//    }
}
