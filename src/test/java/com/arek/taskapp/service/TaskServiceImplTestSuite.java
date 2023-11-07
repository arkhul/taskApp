package com.arek.taskapp.service;

import com.arek.taskapp.model.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class TaskServiceImplTestSuite {

    @Mock
    private TaskServiceImpl taskServiceImpl;

    private List<Task> createTaskList() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Content_1"));
        tasks.add(new Task("Content_2"));
        return tasks;
    }

    @Test
    void shouldFetchEmptyTaskList() {
        // given
        when(taskServiceImpl.getTasks()).thenReturn(List.of());

        // when
        List<Task> tasks = taskServiceImpl.getTasks();

        // then
        Assertions.assertEquals(0, tasks.size());
    }

    @Test
    void shouldFetchTasksFromList() {
        // given
        when(taskServiceImpl.getTasks()).thenReturn(createTaskList());

        // when
        List<Task> tasks = taskServiceImpl.getTasks();

        // then
        Assertions.assertEquals(2, tasks.size());
    }

    @Test
    void shouldFetchOneTaskFromList() {
        // given
        when(taskServiceImpl.getTask(any(Long.class))).thenReturn(createTaskList().get(0));

        // when
        Task task = taskServiceImpl.getTask(5L);

        // then
        Assertions.assertEquals("Content_1", task.getContent());
    }

    @Test
    void shouldAddNewTask() {
        // given
        Task testTask = new Task(1L, "NewContent", LocalDate.now());
        when(taskServiceImpl.addTask(testTask)).thenReturn(testTask);

        // when
        Task task = taskServiceImpl.addTask(testTask);

        // then
        Assertions.assertEquals("NewContent", task.getContent());
    }

    @Test
    void shouldDeleteTask() {
        // given
        taskServiceImpl.addTask(new Task("Content"));

        // when
        taskServiceImpl.deleteTask(1L);

        // then
        Assertions.assertEquals(0, taskServiceImpl.getTasks().size());
    }

    @Test
    void shouldUpdateTaskData() {
        // given
        Task task = new Task("NewContent", LocalDate.of(2020, 10, 10));
        when(taskServiceImpl.putTask(1L, task)).thenReturn(new Task(1l, "NewContent", LocalDate.of(2020, 10, 10)));

        // when
        Task task1 = taskServiceImpl.putTask(1L, task);

        // then
        Assertions.assertEquals("NewContent", task1.getContent());
    }
}