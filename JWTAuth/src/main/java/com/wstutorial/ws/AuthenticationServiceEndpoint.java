package com.wstutorial.ws;

import jwtauthservice.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import utils.PasswordUtils;


@Endpoint
public class AuthenticationServiceEndpoint {
	private static final String NAMESPACE_URI = "http://www.furryaide.com/authentication";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "generateTokenRequest")
	@ResponsePayload
	public GenerateTokenResponse generateToken(@RequestPayload GenerateTokenRequest request) {
		ObjectFactory factory = new ObjectFactory();
		GenerateTokenResponse response = factory.createGenerateTokenResponse();

		// Dummy token generation
		String token = "dummy-token-for-" + request.getUsername();
		response.setToken(token);
		response.setExpiresIn(3600); // Token expiry time in seconds (1 hour)

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "validateTokenRequest")
	@ResponsePayload
	public ValidateTokenResponse validateToken(@RequestPayload ValidateTokenRequest request) {
		ObjectFactory factory = new ObjectFactory();
		ValidateTokenResponse response = factory.createValidateTokenResponse();

		// Dummy token validation
		boolean isValid = request.getToken().startsWith("dummy-token-for-");
		response.setIsValid(isValid);
		response.setUserId(isValid ? request.getToken().substring(14) : null); // Extract username from token

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "hashPasswordRequest")
	@ResponsePayload
	public HashPasswordResponse hashPassword(@RequestPayload HashPasswordRequest request) {
		ObjectFactory factory = new ObjectFactory();
		HashPasswordResponse response = factory.createHashPasswordResponse();

		// Hash the password
		String hashedPassword = PasswordUtils.hashPassword(request.getPassword());
		response.setHashedPassword(hashedPassword);

		return response;
	}
}
