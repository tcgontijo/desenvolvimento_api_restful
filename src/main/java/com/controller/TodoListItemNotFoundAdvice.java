package com.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.service.TodoListItemNotFoundException;

@ControllerAdvice
public class TodoListItemNotFoundAdvice {
        @ResponseBody
        @ExceptionHandler(TodoListItemNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        String todoListItemNotFoundHandler(TodoListItemNotFoundException ex) {
                return ex.getMessage();
        }
}