package com.service;

public class TodoListItemNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    TodoListItemNotFoundException(Integer id) {
        super("Não encontrei o Item " + id);
      }

}