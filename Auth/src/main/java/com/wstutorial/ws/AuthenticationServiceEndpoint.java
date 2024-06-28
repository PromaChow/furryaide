
package com.wstutorial.ws;

import authenticationservice.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.HashMap;
import java.util.Map;

import repository.Database;
import utils.User;
import utils.UserRole;

@Endpoint
public class AuthenticationServiceEndpoint {
	private static final String NAMESPACE_URI = "http://www.furryaide.com/authentication";




	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "loginRequest")
	@ResponsePayload
	public LoginResponse login(@RequestPayload LoginRequest request) throws Exception {

		Map users = Database.getInstance().getUsers();


		if(users.containsKey(request.getUsername())){
			User user = (User) users.get(request.getUsername());
			System.out.println(user);
			ObjectFactory factory = new ObjectFactory();
			LoginResponse response = factory.createLoginResponse();
			response.setToken(user.getRole()+"1234");
			response.setExpiresIn((int) (390000 / 1000));
			response.setRole(user.getRole());
			// Convert ms to seconds
			return response;
		} else {
			ObjectFactory factory = new ObjectFactory();
			LoginResponse response = factory.createLoginResponse();
			response.setToken(null);
			
			response.setRole(null);
			return response;
		}

	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "validateTokenRequest")
	@ResponsePayload
	public ValidateTokenResponse validateToken(@RequestPayload ValidateTokenRequest request) {
		ObjectFactory factory = new ObjectFactory();
		ValidateTokenResponse response = factory.createValidateTokenResponse();
		try {
			User user = validate(request.getToken());
			response.setIsValid(true);
			response.setUserId(user.getUsername());
			response.setRole(user.getRole());// Return user ID or username
		} catch (Exception e) {
			response.setIsValid(false);
		}
		return response;
	}


	private User validate(String token) throws Exception {
		Map tokens = Database.getInstance().getTokens();
		if (tokens.containsKey(token)) {
			return (User) tokens.get(token);
		} else {
			throw new Exception("Invalid token");
		}
	}
}



