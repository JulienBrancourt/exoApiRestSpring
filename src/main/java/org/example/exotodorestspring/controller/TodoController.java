package org.example.exotodorestspring.controller;

import org.example.exotodorestspring.entity.Todo;
import org.example.exotodorestspring.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> findAll() {
        return ResponseEntity.ok(todoService.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<Todo> register(@RequestBody Todo todo) {
        Todo savedTodo = todoService.save(todo);
        return ResponseEntity.ok(savedTodo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> findById(@PathVariable("id") int id) {
        return ResponseEntity.ok(todoService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id, @RequestBody Todo todo) {
        todoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/status/{statut}")
    public ResponseEntity<List<Todo>> findByStatus(@PathVariable("statut") Boolean status) {
        return ResponseEntity.ok(todoService.findByIsValid(status));
    }

}
