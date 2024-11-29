package com.developerhut.intothspring.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.developerhut.intothspring.service.HelloService;

@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private HelloService helloService;
	
	@Test
	public void testDefaultMessage() throws UnsupportedEncodingException, Exception {
		
		when(helloService.getUserNameFromDB()).thenReturn("Jessica");
		
		//String response = testRestTemplate.getForObject("http://localhost:8080/", String.class);
		
		String response = mockMvc.perform(get("/sayHello")).andReturn().getResponse().getContentAsString();
		
		assertThat(response).contains("Hello Jessica");
		
	}
	
}
