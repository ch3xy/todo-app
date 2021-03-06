package com.ebcont.todoapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class TodoControllerTest {

    @Mock
    TodoService todoService;
    TodoController todoController;

    @BeforeEach
    void setUp() {
        todoController = new TodoController(todoService);
    }

    @Test
    void testGetTodos() {
        Todo todo = new Todo();
        todo.setTask("Hello World!");
        given(todoService.getTodos()).willReturn(List.of(todo));
        final ResponseEntity<List<Todo>> todos = todoController.getTodos();
        assertThat(todos.getBody()).containsExactly(todo);
        assertThat(todos.getBody().get(0).getTask()).isEqualTo("Hello World!");
    }

    @Test
    void testPostTodo() {
        Todo todo = new Todo();
        given(todoService.createTodo(todo)).willReturn(todo);
        final ResponseEntity<Todo> todoResult = todoController.createTodo(todo);
        assertThat(todoResult.getBody()).isEqualTo(todo);
    }
}
