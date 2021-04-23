package com.service;

public class TodoListNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    TodoListNotFoundException(Integer id) {
        super("Não encontrei a Lista " + id);
      }

}