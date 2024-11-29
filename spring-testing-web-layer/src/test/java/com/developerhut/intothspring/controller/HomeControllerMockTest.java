package com.developerhut.intothspring.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class HomeControllerMockTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testDefaultMessage() throws UnsupportedEncodingException, Exception {
		
		//String response = testRestTemplate.getForObject("http://localhost:8080/", String.class);
		
		String response = mockMvc.perform(get("/")).andReturn().getResponse().getContentAsString();
		
		assertThat(response).contains("Hello, World");
		
	}
	
}
