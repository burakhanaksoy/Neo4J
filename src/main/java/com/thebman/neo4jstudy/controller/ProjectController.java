package com.thebman.neo4jstudy.controller;

import com.thebman.neo4jstudy.node.Line;
import com.thebman.neo4jstudy.node.Project;
import com.thebman.neo4jstudy.service.LineService;
import com.thebman.neo4jstudy.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/company/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private LineService lineService;

    @GetMapping("/{lineId}")
    ResponseEntity getProjectsByLine(@PathVariable String lineId){
        Line line = lineService.findLine(lineId);
        return new ResponseEntity(line.getProjectSet(), HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity getProjects(){
        return new ResponseEntity(projectService.getProjects(), HttpStatus.OK);
    }

    @DeleteMapping("/{projectId}")
    ResponseEntity deleteLine(@PathVariable String projectId) {
        projectService.deleteProject(projectId);
        return new ResponseEntity(HttpStatus.OK);
    }

//    @PostMapping("/line/projects")
//    ResponseEntity saveProject(@RequestBody Project project) {
//        return new ResponseEntity(projectService.saveProject(project), HttpStatus.CREATED);
//    }
}
