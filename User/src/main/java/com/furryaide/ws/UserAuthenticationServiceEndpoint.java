package com.furryaide.ws;


import com.furryaide.ws.UserAuthenticationService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import repository.UserDatabase;
import userauthservice.AuthenticateUserRequest;
import userauthservice.AuthenticateUserResponse;
import userauthservice.ValidateTokenRequest;
import userauthservice.ValidateTokenResponse;
import userauthservice.*;

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

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "CreateUserRequest")
	@ResponsePayload
	public CreateUserResponse createUser(@RequestPayload CreateUserRequest request) {
		CreateUserResponse response = new CreateUserResponse();

		response.setStatus("User created successfully");
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "ReadUserRequest")
	@ResponsePayload
	public ReadUserResponse readUser(@RequestPayload ReadUserRequest request) {
		ReadUserResponse response = new ReadUserResponse();
		User user = UserDatabase.getInstance().getUser(request.getUsername());
		response.setUser(user);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "UpdateUserRequest")
	@ResponsePayload
	public UpdateUserResponse updateUser(@RequestPayload UpdateUserRequest request) {
		UpdateUserResponse response = new UpdateUserResponse();

		response.setStatus("User updated successfully");
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "DeleteUserRequest")
	@ResponsePayload
	public DeleteUserResponse deleteUser(@RequestPayload DeleteUserRequest request) {
		DeleteUserResponse response = new DeleteUserResponse();
//		UserDatabase.getInstance().deleteUser(request.getUsername());
		response.setStatus("User deleted successfully");
		return response;
	}
}

