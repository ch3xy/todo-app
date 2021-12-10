package com.ebcont.todoapp;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TodoService {

    private TodoRepository repository;

    public List<Todo> getTodos() {
        return repository.findAll();
    }

    public Todo createTodo(Todo todo) {
        return repository.save(todo);
    }
}
