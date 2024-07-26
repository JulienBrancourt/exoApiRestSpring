package org.example.exotodorestspring.service;

import org.example.exotodorestspring.dao.TodoRepository;
import org.example.exotodorestspring.entity.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findAll() {
        return (List<Todo>) todoRepository.findAll();
    }
    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo findById(int id) {
        return todoRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
        todoRepository.deleteById(id);
    }

    public List<Todo> findByIsValid(boolean isValidated) {
        return todoRepository.findByIsValidated(isValidated);
    }
}
