package com.developerhut.intothespring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.developerhut.intothespring.service.CalculatorClient;
import com.developerhut.intothespring.ws.GetResponse;
import com.developerhut.intothespring.ws.Operation;

@SpringBootApplication
public class SpringConsumeSoapWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConsumeSoapWebServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner lookup(CalculatorClient calculatorClient) {
		
		return args -> {
			
			int num1 = 2;
			int num2 = 5;
			Operation operation = Operation.MUL;
			
			GetResponse response = calculatorClient.calculate(num1, num2, operation);
			
			System.err.println("Response - " + response.getResponse());
			
		};
	}
}
