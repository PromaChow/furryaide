package com.furryaide.ws;

import repository.UserDatabase;
import userauthservice.AuthenticateUserResponse;
import userauthservice.ValidateTokenResponse;
import utils.PasswordUtils;
import clients.*;

import static clients.JWTAuthClient.generateToken;

public class UserAuthenticationService {

    public AuthenticateUserResponse authenticateUser(String username, String password) {
        UserDatabase userDatabase = UserDatabase.getInstance();
        String storedHashedPassword = userDatabase.getUserPassword(username);

        AuthenticateUserResponse response = new AuthenticateUserResponse();

        if (storedHashedPassword != null && PasswordUtils.checkPassword(password, storedHashedPassword)) {
            try {
                String token = JWTAuthClient.generateToken(username,password);
                response.setStatusCode(200);
                response.setMessage("Authentication successful");
                response.setToken(token);
            } catch (Exception e) {
                response.setStatusCode(500);
                response.setMessage("Error generating token: " + e.getMessage());
            }
        } else {
            response.setStatusCode(401);
            response.setMessage("Invalid username or password");
        }

        return response;
    }

    public ValidateTokenResponse validateToken(String token) {
        ValidateTokenResponse response = new ValidateTokenResponse();

        try {
            boolean isValid = JWTAuthClient.validateToken(token);
            response.setIsValid(isValid);
            response.setUserId(isValid ? "userIdFromToken" : null); // Assuming userIdFromToken is derived from token
        } catch (Exception e) {
            response.setIsValid(false);
            response.setUserId(null);
        }

        return response;
    }
}
