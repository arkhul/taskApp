package com.arek.taskapp.controller;

import com.arek.taskapp.model.Task;
import com.arek.taskapp.service.TaskServiceImpl;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskServiceImpl taskServiceImpl;

    public TaskController(TaskServiceImpl taskServiceImpl) {
        this.taskServiceImpl = taskServiceImpl;
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskServiceImpl.getTasks();
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable Long id) {
        return taskServiceImpl.getTask(id);
    }

    @PostMapping
    public Task addTask(@RequestBody @Valid Task task) {
        return taskServiceImpl.addTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskServiceImpl.deleteTask(id);
    }

    @PutMapping("/{id}")
    public Task putTask(@PathVariable Long id, @RequestBody @Valid Task task) {
        return taskServiceImpl.putTask(id, task);
    }
}
