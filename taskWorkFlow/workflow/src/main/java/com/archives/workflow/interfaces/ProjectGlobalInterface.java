package com.archives.workflow.interfaces;

import java.util.List;
import java.util.UUID;

import com.archives.workflow.models.Projects;

public interface ProjectGlobalInterface {
    // create
    void createProject(UUID client_id,Projects project);

    // read
    List<Projects> getAllProjectForUser(UUID id);

    Projects getProjectById(int id);

    // update
    void editProject(Projects project);

    // delete
    void deleteProject(int id);
}
