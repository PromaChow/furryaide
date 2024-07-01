package com.furryaide.ws;


import com.furryaide.ws.UserAuthenticationService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import userauthservice.AuthenticateUserRequest;
import userauthservice.AuthenticateUserResponse;
import userauthservice.ValidateTokenRequest;
import userauthservice.ValidateTokenResponse;

@Endpoint
public class UserAuthenticationServiceEndpoint {
	private static final String NAMESPACE_URI = "http://www.furryaide.com/user-authentication";

	private UserAuthenticationService userAuthService = new UserAuthenticationService();

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "authenticateUserRequest")
	@ResponsePayload
	public AuthenticateUserResponse authenticateUser(@RequestPayload AuthenticateUserRequest request) {
		return userAuthService.authenticateUser(request.getUsername(), request.getPassword());
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "validateTokenRequest")
	@ResponsePayload
	public ValidateTokenResponse validateToken(@RequestPayload ValidateTokenRequest request) {
		return userAuthService.validateToken(request.getToken());
	}
}
