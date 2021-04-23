package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.TodoList;
import com.service.TodoListService;

@RestController
@RequestMapping("/todolist")
class TodoListController {

        @Autowired
        private TodoListService service;

        @GetMapping
        public List<TodoList> recuperaTodosRegistros() {
                return service.todos();
        }
        
        @PostMapping
        public TodoList criaNovoRegistro(@RequestBody TodoList todoList) {
                return service.novo(todoList);
        }

        @GetMapping("/{id}")
        public TodoList buscaUmRegistro(@PathVariable Integer id) {
                return service.busca(id);
        }

        @PutMapping("/{id}")
        public TodoList atualizaRegistro(@RequestBody TodoList todoList, @PathVariable Integer id) {
                return service.atualiza(todoList, id);
        }

        @DeleteMapping("/{id}")
        void excluiRegistro(@PathVariable Integer id) {
                service.exclui(id);
        }
}