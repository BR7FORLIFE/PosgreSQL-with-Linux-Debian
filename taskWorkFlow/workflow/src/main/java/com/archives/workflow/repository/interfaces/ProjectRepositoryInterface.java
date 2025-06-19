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

    //update
    void editProject(Projects project);

    //delete
    void deleteProject(int id);
}
