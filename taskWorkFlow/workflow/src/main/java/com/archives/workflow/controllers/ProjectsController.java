package com.archives.workflow.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.archives.workflow.models.Projects;
import com.archives.workflow.services.ProjectService;

@RestController
@RequestMapping("/api")
public class ProjectsController {

    /*
     * - tengo que arreglar el problema de que debo validar que el client_id exista
     * antes de agregar el projecto
     */

    private final ProjectService projectService;

    public ProjectsController(ProjectService projectService) {
        this.projectService = projectService;
    }

    // crear un proyecto segun la client_id y cuerpo del projecto a agregar
    @PostMapping("/project/create/{client_id}")
    public ResponseEntity<String> createProject(@PathVariable UUID client_id, @RequestBody Projects projects) {
        projectService.createProject(client_id, projects);
        return ResponseEntity.status(HttpStatus.CREATED).body("Project Created Succesfull for the Client!");
    }

    @GetMapping("/project/read/{Client_id}")
    public ResponseEntity<List<Projects>> getAllProjectForUser(@PathVariable UUID client_id) {
        List<Projects> allProjects = projectService.getAllProjectForUser(client_id);
        return ResponseEntity.status(HttpStatus.OK).body(allProjects);
    }

    @GetMapping("/project/read/{client_id}/{id}")
    public ResponseEntity<Projects> getProjectById(@PathVariable UUID client_id, int id){
        Projects project = projectService.getProjectById(id);
        return ResponseEntity.status(HttpStatus.OK).body(project);
    }

    @PutMapping("/project/update/{client_id}/{id}")
    public void editProject(){

    }

    @DeleteMapping("/project/delete/{client_id}/{id}")
    public void deleteProject(int id){

    }
}
