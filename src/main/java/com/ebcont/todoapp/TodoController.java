package com.ebcont.todoapp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @GetMapping("/api/todos")
    public ResponseEntity<Void> getTodos() {
        return ResponseEntity.ok().build();
    }

}
