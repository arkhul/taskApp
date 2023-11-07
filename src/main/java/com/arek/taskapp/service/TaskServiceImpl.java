package com.arek.taskapp.service;

import com.arek.taskapp.exception.TaskError;
import com.arek.taskapp.exception.TaskException;
import com.arek.taskapp.model.Task;
import com.arek.taskapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTask(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskException(TaskError.TASK_NOT_FOUND));
    }

    @Override
    public Task addTask(Task task) {
        task.setCreationDate(LocalDate.now());
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.findById(id)
                .orElseThrow(() -> new TaskException(TaskError.TASK_NOT_FOUND));
        taskRepository.deleteById(id);
    }

    @Override
    public Task putTask(Long id, Task task) {
        if (task.getCreationDate() == null) {
            throw new TaskException(TaskError.INCOMPLETE_DATA);
        }
        return taskRepository.findById(id)
                .map(taskFromDb -> {
                    taskFromDb.setContent(task.getContent());
                    taskFromDb.setCreationDate(task.getCreationDate());
                    return taskRepository.save(taskFromDb);
                }).orElseThrow(() -> new TaskException(TaskError.TASK_NOT_FOUND));
    }
}
