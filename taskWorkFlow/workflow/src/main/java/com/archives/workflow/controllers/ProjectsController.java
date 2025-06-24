package com.archives.workflow.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.archives.workflow.constants.ProjectResponseEntity;
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
    public ResponseEntity<String> createProject(@PathVariable UUID client_id, @RequestBody Projects projects) {
        ResponseEntity<String> validation = ProjectResponseEntity.Validate(client_id,
                projects, HttpStatus.CREATED,
                "Project has been created!!", "Client_id or project is null!");
        projectService.createProject(client_id, projects);
        return validation;
    }

    @GetMapping("/project/read/{Client_id}")
    public ResponseEntity<List<Projects>> getAllProjectForUser(@PathVariable UUID client_id) {
        List<Projects> allProjects = projectService.getAllProjectForUser(client_id);
        ResponseEntity<List<Projects>> validation = ProjectResponseEntity.Validate(client_id, HttpStatus.OK,
                allProjects, List.of(new Projects()));
        return validation;
    }

    @GetMapping("/project/read/{client_id}/{id}")
    public ResponseEntity<Projects> getProjectById(@PathVariable UUID client_id, Integer id) {
        Projects project = projectService.getProjectById(id);
        ResponseEntity<Projects> validation = ProjectResponseEntity.Validate(client_id, HttpStatus.OK, project,
                new Projects());
        return validation;
    }

    // TODo - debo verificar la id del proyecto si existe!
    @PutMapping("/project/update/{client_id}/{id}")
    public ResponseEntity<String> editProject(@PathVariable UUID client_id, Integer id, @RequestBody Projects project) {
        ResponseEntity<String> validation = ProjectResponseEntity.Validate(client_id, id, project, HttpStatus.CREATED,
                "Project has been editing!", "Client_id, id, projects is null verify content!");
        projectService.editProject(client_id, id, project);
        return validation;
    }

    @DeleteMapping("/project/delete/{client_id}/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable UUID client_id, @PathVariable Integer id) {
        ResponseEntity<String> validation = ProjectResponseEntity.Validate(client_id, HttpStatus.OK, "Delete succesful", "client_id or id project is null!");
        projectService.deleteProject(client_id, id);
        return validation;
    }
}
