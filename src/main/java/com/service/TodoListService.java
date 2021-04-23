package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.domain.TodoList;

import com.repository.TodoListRepository;

@Service
public class TodoListService {

        @Autowired
        TodoListRepository repository;

        public List<TodoList> todos() {
                return repository.findAll();
        }

        public TodoList novo(TodoList todoList) {
                return repository.save(todoList);
        }

        public TodoList busca(Integer id) {
                return repository.findById(id).orElseThrow(() -> new TodoListNotFoundException(id));
        }

        public TodoList atualiza(TodoList todoList, Integer id) {
        		todoList.setId(id);
                return repository.save(todoList);
        }

        public void exclui(@PathVariable Integer id) {
                repository.deleteById(id);
        }

}