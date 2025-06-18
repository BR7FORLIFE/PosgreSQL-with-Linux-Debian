package com.archives.workflow.repository.interfaces;

import java.util.List;
import java.util.UUID;

import com.archives.workflow.models.Projects;

public interface  ProjectRepositoryInterface {
    //create
    void createProject(Projects project);

    //read
    List<Projects> getAllProjectForUser(UUID id);
    Projects getProjectById(int id);
    Projects getDetailsProjectForUser(Projects projects); //<-- esto pq hay un atributo Client que permite saber de que usario es

    //update
    void editProject(Projects project);

    //delete
    void deleteProject(int id);
}
