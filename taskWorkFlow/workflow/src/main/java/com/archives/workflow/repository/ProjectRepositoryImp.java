package com.archives.workflow.repository;

import java.util.List;

import com.archives.workflow.models.Client;
import com.archives.workflow.models.Projects;
import com.archives.workflow.repository.interfaces.ProjectRepositoryInterface;

public class ProjectRepositoryImp implements ProjectRepositoryInterface {
    
    @Override
    public void createProject(Projects project){
       
    }

    @Override
    public List<Projects> getAllProjectForUser(Client client){
        return null;
    }

    @Override
    public Projects getDetailsForUser(Projects projects){
        return null;
    }

    @Override
    public Projects editProject(int id){
        return null;
    }

    @Override
    public void deleteProject(int id){
        
    }
}
