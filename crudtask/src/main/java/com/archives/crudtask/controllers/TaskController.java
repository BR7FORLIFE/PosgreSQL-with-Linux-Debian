package com.archives.crudtask.controllers;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private List<Task> task;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTask() {
        task = taskService.getAllTask();
        return ResponseEntity.ok(task);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable UUID id){
        Task task = taskService.getTaskById(id);

        if(task == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok().body(task);
    }

    @GetMapping("/iscomplete/{isComplete}")
    public ResponseEntity<List<Task>> getTaskByCompleteOrIncomplete(@PathVariable boolean isComplete) {
        task = taskService.getTaskByCompleteOrIncomplete(isComplete);
        return ResponseEntity.ok(task);
    }

    @GetMapping("/progress/{isProgress}")
    public ResponseEntity<List<Task>> getTaskByProgress(@PathVariable boolean isProgress) {
        task = taskService.getTaskByProgress(isProgress);
        return ResponseEntity.ok(task);
    }

    @PostMapping()
    public ResponseEntity<String> aggTask(@RequestBody Task task) {
        taskService.aggTask(task);
        URI location = URI.create("/task/" + task.getId());
        return ResponseEntity.created(location).body("Task created successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateTask(@PathVariable UUID id, @RequestBody Task task) {
        task.setId(id);
        taskService.updateTask(task);
        return ResponseEntity.ok("Update task by id: " + id.toString() + " succesfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable UUID id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().body("Delete task succesfully by id: " + id.toString());
    }
}
