package com.developerhut.intothespring.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class DemoController {

	@GetMapping
	public String getTest(HttpServletRequest request) {
		//return "GET : Hello World";
		return "CSRF Token : " + ((CsrfToken) request.getAttribute("_csrf")).getToken();
	}
	
	@PostMapping(value = "/white")
	public String postTest() {
		return "POST : Hello World";
	}
	
	@PutMapping
	public String putTest() {
		return "PUT : Hello World";
	}
	
	@DeleteMapping
	public String deleteTest() {
		return "DELETE : Hello World";
	}
	
}
