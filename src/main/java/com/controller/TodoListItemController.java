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

import com.domain.TodoListItem;
import com.service.TodoListItemService;

@RestController
@RequestMapping("/todolistitem")
class TodoListItemController {

        @Autowired
        private TodoListItemService service;

        @GetMapping
        public List<TodoListItem> recuperaTodosRegistros() {
                return service.todos();
        }
        
        @PostMapping
        public TodoListItem criaNovoRegistro(@RequestBody TodoListItem todoListItem) {
                return service.novo(todoListItem);
        }

        @GetMapping("/{id}")
        public TodoListItem buscaUmRegistro(@PathVariable Integer id) {
                return service.busca(id);
        }

        @PutMapping("/{id}")
        public TodoListItem atualizaRegistro(@RequestBody TodoListItem todoListItem, @PathVariable Integer id) {
                return service.atualiza(todoListItem, id);
        }

        @DeleteMapping("/{id}")
        void excluiRegistro(@PathVariable Integer id) {
                service.exclui(id);
        }
}