package com.archives.crudtask.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.archives.crudtask.models.Task;
import com.archives.crudtask.repository.TaskRepositoryImp;

@Service
public class TaskService {
    private final TaskRepositoryImp taskRepositoryImp;

    public TaskService(TaskRepositoryImp taskRepositoryImp) {
        this.taskRepositoryImp = taskRepositoryImp;
    }

    public List<Task> getAllTask() {
        return taskRepositoryImp.getAllTask();
    }

    public Task getTaskById(UUID id){
        return taskRepositoryImp.getTaskById(id);
    }

    public List<Task> getTaskByCompleteOrIncomplete(boolean isComplete) {
        return taskRepositoryImp.getTaskByCompleteOrIncomplete(isComplete);
    }

    public List<Task> getTaskByProgress(boolean isProgress) {
        return taskRepositoryImp.getTaskByProgress(isProgress);
    }

    public void aggTask(Task task) {
        try {
            if (task.getIsComplete() instanceof Boolean && task.getIsProgress() instanceof Boolean) {
                taskRepositoryImp.aggTask(task);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    public void updateTask(Task task) {
        try {
            if (task.getIsComplete() instanceof Boolean && task.getIsProgress() instanceof Boolean) {
                taskRepositoryImp.updateTask(task);
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    public void deleteTask(UUID id) {
        taskRepositoryImp.deleteTask(id);
    }
}
