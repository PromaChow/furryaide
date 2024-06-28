
package com.wstutorial.ws;

import java.util.ArrayList;
import java.util.List;

import customerservice.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CustomerServiceEndpoint {
	private static final String NAMESPACE_URI = "http://www.wstutorial.com/ws/CustomerService";

	

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "loginRequest")
	@ResponsePayload
	public LoginResponse login(@RequestPayload LoginRequest request) throws Exception {
		if ("proma_1234".equals(request.getUsername()) && "1234".equals(request.getPassword())) {
			String token = "fsjfnjsnskjfnsf";

			ObjectFactory factory = new ObjectFactory();
			LoginResponse response = factory.createLoginResponse();
			response.setToken(token);
			response.setExpiresIn((int) (390000 / 1000)); // Convert ms to seconds
			return response;
		} else {
			throw new Exception("Invalid credentials");
		}
	}



}