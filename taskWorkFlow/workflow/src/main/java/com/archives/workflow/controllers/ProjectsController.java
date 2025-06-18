package com.archives.workflow.controllers;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.archives.workflow.models.Projects;
import com.archives.workflow.services.ProjectService;

@RestController
@RequestMapping("/api")
public class ProjectsController {

    /* 
        - tengo que arreglar el problema de que debo validar que el client_id exista antes de agregar el projecto
    */ 
    
    private final ProjectService projectService;

    public ProjectsController(ProjectService projectService){
        this.projectService = projectService;
    }

    @PostMapping("/project/{client_id}")
    public ResponseEntity<String> createProject(@PathVariable UUID client_id, @RequestBody Projects projects){
        projectService.createProject(client_id,projects);
        return ResponseEntity.status(HttpStatus.CREATED).body("Project Created Succesfull for the Client!");
    }
}
