package com.auth;

import java.util.HashMap;
import java.util.Map;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import authentication.LoginRequest;
import authentication.LoginResponse;
import authentication.ValidateTokenRequest;
import authentication.ValidateTokenResponse;
import authentication.ObjectFactory;

@Endpoint
public class AuthenticationServiceEndpoint {
	private static final String NAMESPACE_URI = "http://www.example.com/authentication";


	@Value("${jwt.expiration}")
	private long jwtExpirationInMs;

	private Map<String, String> tokens = new HashMap<String, String>();

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "loginRequest")
	@ResponsePayload
	public LoginResponse login(@RequestPayload LoginRequest request) throws Exception {
		if ("proma_1234".equals(request.getUsername()) && "1234".equals(request.getPassword())) {
			String token = generate(request.getUsername());

			ObjectFactory factory = new ObjectFactory();
			LoginResponse response = factory.createLoginResponse();
			response.setToken(token);
			response.setExpiresIn((int) (jwtExpirationInMs / 1000)); // Convert ms to seconds
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
