package com.developerhut.intothespring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.developerhut.intothespring.service.CalculatorClient;

@Configuration
public class CalculatorConfig {

	@Bean
	public Jaxb2Marshaller marshaller() {
		
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		
		// this package must match the package in the <generatePackage> specified in
	    // pom.xml
		marshaller.setContextPath("com.developerhut.intothespring.ws");
		
		return marshaller;
		
	}
	
	@Bean
	public CalculatorClient calculatorClient(Jaxb2Marshaller marshaller) {
	
		CalculatorClient client = new CalculatorClient();
		
		client.setDefaultUri("http://localhost:8080/calculatorws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		
		return client;
	}
	
}
