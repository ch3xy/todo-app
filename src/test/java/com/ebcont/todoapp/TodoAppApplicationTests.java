package com.ebcont.todoapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
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
				.expectBody().json("[\"hello world\"]");
	}
}
