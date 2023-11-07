package com.arek.taskapp.service;

import com.arek.taskapp.model.Task;

import java.util.List;

public interface TaskService {

    List<Task> getTasks();

    Task getTask(Long id);

    Task addTask(Task task);

    void deleteTask(Long id);

    Task putTask(Long id, Task task);
}
