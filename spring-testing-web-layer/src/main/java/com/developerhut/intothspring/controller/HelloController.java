package com.developerhut.intothspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developerhut.intothspring.service.HelloService;

@RestController
public class HelloController {

	@Autowired
	private HelloService helloService;
	
	@GetMapping(value = "/sayHello")
	public String sayHello() {
		String username = helloService.getUserNameFromDB();
		return "Hello " + username;
	}
	
}
