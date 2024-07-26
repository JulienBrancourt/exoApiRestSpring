package org.example.exotodorestspring.dao;

import org.example.exotodorestspring.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    List<Todo> findByIsValidated(Boolean isValidated);
}
