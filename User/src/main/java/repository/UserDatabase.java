package repository;

import userauthservice.User;
import userauthservice.UserRole;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class UserDatabase {
    private static final String FILE_NAME = "database/user-database.txt";
    private static UserDatabase instance;
    private Map<String, User> users;

    private UserDatabase() {
        users = new HashMap<String, User>();
        loadUsers();
    }

    public static UserDatabase getInstance() {
        if (instance == null) {
            instance = new UserDatabase();
        }
        return instance;
    }
    public String getUserPassword(String username) {
        if (users.get(username)!=null){
        return users.get(username).getPassword();}
        return null;
    }


    private void loadUsers() {
        BufferedReader reader = null;
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(FILE_NAME);
            if (inputStream == null) {
                throw new FileNotFoundException("File not found: " + FILE_NAME);
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 3) {
                    String username = parts[0];
                    String hashedPassword = parts[1];
                    String role = parts[2];
                    User user = new User();
                    user.setPassword(hashedPassword);
                    user.setRole(UserRole.valueOf(role));
                    user.setUsername(username);
                    users.put(username, user);
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
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public void addUser(String username, String hashedPassword, String role) {
        User user = new User();
        user.setPassword(hashedPassword);
        user.setRole(UserRole.valueOf(role));
        user.setUsername(username);
        users.put(username, user);

        saveUsers();
    }

    private void saveUsers() {
        BufferedWriter writer = null;
        try {
            URL resource = getClass().getClassLoader().getResource(FILE_NAME);
            if (resource == null) {
                throw new FileNotFoundException("File not found: " + FILE_NAME);
            }
            writer = new BufferedWriter(new FileWriter(new File(resource.toURI())));
            for (Map.Entry<String, User> entry : users.entrySet()) {
                User user = entry.getValue();
                String hashedPassword = "hash"+ user.getPassword();
                writer.write(user.getUsername() + ":" + hashedPassword + ":" + user.getRole());
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
