package com.archives.crudtask.repository.interfaces;

import java.util.List;
import java.util.UUID;

import com.archives.crudtask.models.Task;

public interface TaskRepoInterface {
    List<Task> getAllTask();
    Task getTaskById(UUID id);
    List<Task> getTaskByCompleteOrIncomplete(boolean isComplete);
    List<Task> getTaskByProgress(boolean isProgress);
    void aggTask(Task task);
    void updateTask(Task task);
    void deleteTask(UUID id);
}
