package com.archives.workflow.repository.interfaces;

import java.util.List;

import com.archives.workflow.models.Projects;

public interface  ProjectRepositoryInterface {
    //create
    void createProject(Projects project);
    List<Projects> getAllProjectForUser();
    Projects getDetailsProjectForUser(Projects projects); //<-- esto pq hay un atributo Client que permite saber de que usario es
    Projects editProject(int id);
    void deleteProject(int id);
}
