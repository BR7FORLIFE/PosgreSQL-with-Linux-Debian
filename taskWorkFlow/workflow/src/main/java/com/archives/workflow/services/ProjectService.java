package com.archives.workflow.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.archives.workflow.interfaces.ProjectGlobalInterface;
import com.archives.workflow.models.Projects;
import com.archives.workflow.repository.ClientRepositoryImp;
import com.archives.workflow.repository.ProjectRepositoryImp;

@Service
public class ProjectService implements ProjectGlobalInterface {
    private final ProjectRepositoryImp projectRepositoryImp;
    private final ClientRepositoryImp clientRepositoryImp;

    public ProjectService(ProjectRepositoryImp projectRepositoryImp, ClientRepositoryImp clientRepositoryImp) {
        this.projectRepositoryImp = projectRepositoryImp;
        this.clientRepositoryImp = clientRepositoryImp;
    }

    @Override
    public void createProject(UUID client_id, Projects project) {
        // ToDo
        // [] debo hacer una logica para corroborar que de vd exista dicho usuario en la
        // base de datos!

        if (true) {
            projectRepositoryImp.createProject(client_id, project);
        }
    }

    @Override
    public List<Projects> getAllProjectForUser(UUID id) {
        return projectRepositoryImp.getAllProjectForUser(id);
    }

    @Override
    public Projects getProjectById(Integer id) {
        return projectRepositoryImp.getProjectById(id);
    }

    @Override
    public void editProject(UUID client_id, Integer id, Projects project) {
        projectRepositoryImp.editProject(client_id, id ,project);
    }

    @Override
    public void deleteProject(Integer id) {
        projectRepositoryImp.deleteProject(id);
    }
}
