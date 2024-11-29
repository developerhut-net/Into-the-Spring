package com.developerhut.intothspring.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

	public String getUserNameFromDB() {
		return "Jon Doe";
	}
	
}
