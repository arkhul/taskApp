package com.arek.taskapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TaskExceptionHandler {

    @ExceptionHandler(value = TaskException.class)
    public ResponseEntity<ErrorInfo> handleException(TaskException e) {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        if (TaskError.TASK_NOT_FOUND.equals(e.getTaskError())) {
            httpStatus = HttpStatus.NOT_FOUND;
        } else if (TaskError.INCOMPLETE_DATA.equals(e.getTaskError())) {
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return ResponseEntity.status(httpStatus).body(new ErrorInfo(e.getTaskError().getMessage()));
    }
}
