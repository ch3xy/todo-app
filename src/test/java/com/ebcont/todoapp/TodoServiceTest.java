package com.ebcont.todoapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class TodoServiceTest {

    @Mock
    private TodoRepository repository;

    private TodoService todoService;

    @BeforeEach
    void setUp() {
        todoService = new TodoService(repository);
    }

    @Test
    void testGetTodos_isEmpty() {

        List<Todo> todos = todoService.getTodos();

        assertThat(todos).isNotNull().isEmpty();
    }

    @Test
    void testGetTodos_returnsSingleTodo() {

        Todo todo = new Todo();
        given(repository.findAll()).willReturn(List.of(todo));

        List<Todo> todos = todoService.getTodos();

        assertThat(todos).containsExactly(todo);
    }

    @Test
    void test_createTodo() {

        Todo todo = new Todo();
        given(repository.save(todo)).willReturn(todo);

        Todo result = todoService.createTodo(todo);

        assertThat(result).isEqualTo(todo);
    }
}
