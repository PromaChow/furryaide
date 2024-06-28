
package com.wstutorial.ws;

import authenticationservice.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.HashMap;
import java.util.Map;
import utils.UserRole;

@Endpoint
public class AuthenticationServiceEndpoint {
	private static final String NAMESPACE_URI = "http://www.furryaide.com/authentication";

	private Map<String, String> tokens = new HashMap<String, String>();

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "loginRequest")
	@ResponsePayload
	public LoginResponse login(@RequestPayload LoginRequest request) throws Exception {
		if ("proma_1234".equals(request.getUsername()) && "1234".equals(request.getPassword())) {
			String token = "fsjfnjsnskjfnsf";

			ObjectFactory factory = new ObjectFactory();
			LoginResponse response = factory.createLoginResponse();
			response.setToken(token);
			response.setExpiresIn((int) (390000 / 1000));
			response.setRole(UserRole.CUSTOMER);
			// Convert ms to seconds
			return response;
		} else {
			throw new Exception("Invalid credentials");
		}
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "validateTokenRequest")
	@ResponsePayload
	public ValidateTokenResponse validateToken(@RequestPayload ValidateTokenRequest request) {
		ObjectFactory factory = new ObjectFactory();
		ValidateTokenResponse response = factory.createValidateTokenResponse();
		try {
			String username = validate(request.getToken());
			response.setIsValid(true);
			response.setUserId(username); // Return user ID or username
		} catch (Exception e) {
			response.setIsValid(false);
		}
		return response;
	}

	private String generate(String username) {
		String token = "help";
		tokens.put(token, username);
		return token;
	}

	private String validate(String token) throws Exception {
		if (tokens.containsKey(token)) {
			return tokens.get(token);
		} else {
			throw new Exception("Invalid token");
		}
	}
}



