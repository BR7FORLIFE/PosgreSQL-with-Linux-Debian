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
    @PostMapping("/project/create/{client_id}")
    public ResponseEntity<String> createProject(@PathVariable UUID client_id, @RequestBody Projects projects) {
        ProjectResponseEntity.uuidValidate(client_id, projects, HttpStatus.CREATED, "Project has been created!!");
        projectService.createProject(client_id, projects);
        return ResponseEntity.status(HttpStatus.CREATED).body("Project Created Succesfull for the Client!");
    }

    //hay que mejorar los dos returns de los metodos el del estatico y de este metodo!
    @GetMapping("/project/read/{Client_id}")
    public ResponseEntity<List<Projects>> getAllProjectForUser(@PathVariable UUID client_id) {
        ProjectResponseEntity.uuidValidate(client_id, HttpStatus.OK, List.of(new Projects()));
        List<Projects> allProjects = projectService.getAllProjectForUser(client_id);
        return null;
    }

    @GetMapping("/project/read/{client_id}/{id}")
    public ResponseEntity<Projects> getProjectById(@PathVariable UUID client_id, Integer id) {
        if (!(client_id instanceof UUID))
            return ResponseEntity.badRequest().body(new Projects());
        if (!(id instanceof Integer))
            return ResponseEntity.badRequest().body(new Projects());
        Projects project = projectService.getProjectById(id);
        return ResponseEntity.status(HttpStatus.OK).body(project);
    }

    // TODo - debo verificar la id del proyecto si existe!
    @PutMapping("/project/update/{client_id}/{id}")
    public ResponseEntity<String> editProject(@PathVariable UUID client_id, Integer id, @RequestBody Projects project) {
        if (!(client_id instanceof UUID))
            return ResponseEntity.badRequest().body("Expected UUID for client_id");
        if (!(id instanceof Integer))
            return ResponseEntity.badRequest().body("Expected id of project instanceof Integer!");
        if (!(project == null))
            return ResponseEntity.badRequest().body("The project is null expected object full!");
        projectService.editProject(client_id, id, project);
        return ResponseEntity.ok().body("Project has been editing!");
    }

    @DeleteMapping("/project/delete/{client_id}/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable UUID client_id, @PathVariable Integer id) {
        if (!(client_id instanceof UUID))
            return ResponseEntity.badRequest().body("Client_id not UUID");
        if (!(id instanceof Integer))
            return ResponseEntity.badRequest().body("The id the project not Integer!");
        return ResponseEntity.ok().body("Project remove succesfull!");
    }
}
