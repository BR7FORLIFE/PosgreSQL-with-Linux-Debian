package com.archives.workflow.interfaces;

import java.util.List;
import java.util.UUID;

import com.archives.workflow.models.Projects;

public interface ProjectGlobalInterface {
    // create
    void createProject(UUID client_id, Projects project);

    // read
    List<Projects> getAllProjectForUser(UUID id);

    Projects getProjectById(Integer id);

    // update
    void editProject(UUID client_id, Integer id, Projects project);

    // delete
    void deleteProject(Integer id);
}
