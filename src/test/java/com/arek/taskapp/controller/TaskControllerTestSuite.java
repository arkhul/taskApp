package com.arek.taskapp.controller;

import com.arek.taskapp.model.LocalDateAdapter;
import com.arek.taskapp.model.Task;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitWebConfig
@WebMvcTest(TaskController.class)
class TaskControllerTestSuite {

    @MockBean
    private TaskController taskController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldFetchEmptyTaskList() throws Exception {
        // given
        when(taskController.getTasks()).thenReturn(List.of());

        // when & then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/tasks")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }


    @Test
    void shouldFetchTasksFromList() throws Exception {
        // given
        List<Task> taskList = List.of(
                new Task(1L, "Content_1", LocalDate.now()),
                new Task(2L, "Content_2", LocalDate.now()));
        when(taskController.getTasks()).thenReturn(taskList);

        // when & then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/tasks")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].content", Matchers.is("Content_1")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].content", Matchers.is("Content_2")));
    }

    @Test
    void shouldFetchOneTaskFromList() throws Exception {
        // given
        Task task = new Task(1L, "Content1", LocalDate.now());
        when(taskController.getTask(any(Long.class))).thenReturn(task);

        // When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/tasks/" + any(Long.class))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", Matchers.is("Content1")));
    }

    @Test
    void shouldAddNewTask() throws Exception {
        // given
        Task task = new Task(1L, "Content", LocalDate.now());
        when(taskController.addTask(any(Task.class))).thenReturn(task);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter().nullSafe())
                .create();
        String jsonContent = gson.toJson(task);
        // when & then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", Matchers.is("Content")));
    }

    @Test
    void shouldDeleteTask() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .delete("/tasks/" + any(Long.class))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));
    }

    @Test
    void shouldUpdateTask() throws Exception {
        // given
        Task task = new Task("NewContent", LocalDate.now());
        when(taskController.putTask(any(Long.class), any(Task.class)))
                .thenReturn(task);
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter().nullSafe())
                .create();
        String jsonContent = gson.toJson(task);

        // when & then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/tasks/" + any(Long.class), any(Task.class))
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", Matchers.is("NewContent")));
    }
}