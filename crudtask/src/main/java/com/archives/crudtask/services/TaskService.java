package com.archives.crudtask.services;

import org.springframework.stereotype.Service;

import com.archives.crudtask.repository.TaskRepositoryImp;

@Service
public class TaskService {
    private final TaskRepositoryImp taskRepositoryImp;

    public TaskService(TaskRepositoryImp taskRepositoryImp){
        this.taskRepositoryImp = taskRepositoryImp;
    }

    
}
