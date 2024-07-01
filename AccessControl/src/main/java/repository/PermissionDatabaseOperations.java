package repository;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class PermissionDatabaseOperations {

    private static final String USER_PERMISSIONS_FILE = "database/user-permission.txt";
    private Map<String, String> userPermissions = new HashMap<String, String>();



    public Map<String, String> getPermissions() {
        BufferedReader reader = null;
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(USER_PERMISSIONS_FILE);
            if (inputStream == null) {
                throw new FileNotFoundException("File not found: " + USER_PERMISSIONS_FILE);
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    userPermissions.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return userPermissions;
    }

}

