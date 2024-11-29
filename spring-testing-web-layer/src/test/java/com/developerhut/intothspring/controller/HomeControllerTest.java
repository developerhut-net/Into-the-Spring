package com.developerhut.intothspring.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class HomeControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Test
	public void testDefaultMessage() {
		
		String response = testRestTemplate.getForObject("http://localhost:8080/", String.class);
		
		assertThat(response).contains("Hello, World");
		
	}
	
}
