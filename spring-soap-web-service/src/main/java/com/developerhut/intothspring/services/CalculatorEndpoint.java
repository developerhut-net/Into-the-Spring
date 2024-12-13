package com.developerhut.intothspring.services;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.developerhut.intothespring.ws.GetRequest;
import com.developerhut.intothespring.ws.GetResponse;
import com.developerhut.intothespring.ws.Operation;

@Endpoint
public class CalculatorEndpoint {

	private static final String NAMSPACE = "http://ws.intothespring.developerhut.com";
	
	@PayloadRoot(namespace = NAMSPACE, localPart = "getRequest")
	@ResponsePayload
	public GetResponse calculate(@RequestPayload GetRequest request) {
		
		GetResponse response = new GetResponse();
		
		Operation operation = request.getOperation();
		
		if(Operation.ADD.equals(operation)) {
		
			int result = request.getNum1() + request.getNum2();
			response.setResponse(result);
		} else if(Operation.SUB.equals(operation)) {
		
			int result = request.getNum1() - request.getNum2();
			response.setResponse(result);
		} else if(Operation.MUL.equals(operation)) {
		
			int result = request.getNum1() * request.getNum2();
			response.setResponse(result);
		}
		
		return response;
	}
	
}
