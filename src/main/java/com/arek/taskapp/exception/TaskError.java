package com.arek.taskapp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TaskError {

    TASK_NOT_FOUND("Task does not exist"),
    INCOMPLETE_DATA("You have not provided all the required data");

    private String message;
}
