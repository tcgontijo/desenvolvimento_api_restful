package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.domain.TodoListItem;
import com.repository.TodoListItemRepository;

@Service
public class TodoListItemService {

        @Autowired
        TodoListItemRepository repository;

        public List<TodoListItem> todos() {
                return repository.findAll();
        }

        public TodoListItem novo(TodoListItem todoListItem) {
                return repository.save(todoListItem);
        }

        public TodoListItem busca(Integer id) {
                return repository.findById(id).orElseThrow(() -> new TodoListItemNotFoundException(id));
        }

        public TodoListItem atualiza(TodoListItem todoListItem, Integer id) {
        	todoListItem.setId(id);
                return repository.save(todoListItem);
        }

        public void exclui(@PathVariable Integer id) {
                repository.deleteById(id);
        }

}