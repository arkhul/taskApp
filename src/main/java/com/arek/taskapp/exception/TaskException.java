package com.arek.taskapp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TaskException extends RuntimeException {

    private TaskError taskError;
}
