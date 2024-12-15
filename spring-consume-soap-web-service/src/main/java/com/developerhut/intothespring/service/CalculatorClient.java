package com.developerhut.intothespring.service;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.developerhut.intothespring.ws.GetRequest;
import com.developerhut.intothespring.ws.GetResponse;
import com.developerhut.intothespring.ws.Operation;

public class CalculatorClient extends WebServiceGatewaySupport {

	public GetResponse calculate(int num1, int num2, Operation operation) {
	
		GetRequest request = new GetRequest();
		request.setNum1(num1);
		request.setNum2(num2);
		request.setOperation(operation);
		
		GetResponse response = (GetResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8080/calculatorws/calculator", request, new SoapActionCallback("http://ws.intothespring.developerhut.com/getRequest"));
		
		return response;
		
	}
	
}
