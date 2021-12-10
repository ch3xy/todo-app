package com.ebcont.todoapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class TodoAppApplicationTests {

    @Test
    void test_listAllTodos() {
        WebTestClient
            .bindToServer()
            .baseUrl("http://localhost:8080")
            .build()
            .get()
            .uri("/api/todos")
            .exchange()
            .expectStatus().isOk()
//				.expectHeader().valueEquals("Content-Type", "application/json")
            .expectBody().json("[{\"id\":1,\"task\":\"hello world\"}]");
    }

	@Test
	void test_createTodo() {
		WebTestClient
			.bindToServer()
			.baseUrl("http://localhost:8080")
			.build()
			.post()
			.uri("/api/todos")
			.contentType(MediaType.APPLICATION_JSON)
			.bodyValue("{\"task\":\"secondTask\"}")
			.accept(MediaType.APPLICATION_JSON)
			.exchange()
			.expectStatus().isOk();
	}
}
