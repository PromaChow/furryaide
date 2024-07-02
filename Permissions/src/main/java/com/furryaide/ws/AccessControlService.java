package com.furryaide.ws;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.Map;
import repository.*;


import static clients.JWTAuthClient.validateToken;

public class AccessControlService {
    private static final String JWT_AUTH_SERVICE_URL = "http://localhost:3000/wsdlfirst/authenticationService";


    public boolean checkPermission(String token, String permission) {
        PermissionDatabaseOperations db = new PermissionDatabaseOperations();
        Map <String, String> userPermissions = db.getPermissions();
        try {
            String username = getUsernameFromToken(token);
            if (username != null && userPermissions.containsKey(username)) {
                String permissions = userPermissions.get(username);
                return permissions.contains(permission);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private String getUsernameFromToken(String token) throws IOException, ParserConfigurationException, SAXException {

        if (validateToken(token)) {
            return parseUsernameFromToken(token);
        }
        return null;
    }



    private String parseUsernameFromToken(String token) {
        if (token.startsWith("dummy-token-for-")) {


            return token.substring("dummy-token-for-".length(),token.length());
        }
        return null;
    }
}
