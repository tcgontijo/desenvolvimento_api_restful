package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.service.TodoListNotFoundException;

@ControllerAdvice
public class TodoListNotFoundAdvice {
        @ResponseBody
        @ExceptionHandler(TodoListNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        String todoListNotFoundHandler(TodoListNotFoundException ex) {
                return ex.getMessage();
        }

}