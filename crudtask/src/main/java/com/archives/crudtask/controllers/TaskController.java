package com.archives.crudtask.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.archives.crudtask.models.Task;
import com.archives.crudtask.services.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTask() {
        return taskService.getAllTask();
    }

    @GetMapping("/iscomplete/{isComplete}")
    public List<Task> getTaskByCompleteOrIncomplete(@PathVariable boolean isComplete) {
        return taskService.getTaskByCompleteOrIncomplete(isComplete);
    }

    @GetMapping("/progress")
    public List<Task> getTaskByProgress() {
        return taskService.getTaskByProgress();
    }

    @PostMapping()
    public void aggTask(@RequestBody Task task) {
        taskService.aggTask(task);
    }

    @PutMapping("/update/{task}")
    public void updateTask(@RequestBody Task task) {
        taskService.updateTask(task);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable UUID id) {
        taskService.deleteTask(id);
    }
}
