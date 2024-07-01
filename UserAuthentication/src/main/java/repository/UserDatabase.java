package repository;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class UserDatabase {
    private static final String FILE_NAME = "database/user-database.txt";
    private static UserDatabase instance;
    private Map<String, String> users;

    private UserDatabase() {
        users = new HashMap<String, String>();
        loadUsers();
    }

    public static UserDatabase getInstance() {
        if (instance == null) {
            instance = new UserDatabase();
        }
        return instance;
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
                if (parts.length == 2) {
                    users.put(parts[0], parts[1]);
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

    public String getUserPassword(String username) {
        return users.get(username);
    }

    public void addUser(String username, String hashedPassword) {
        users.put(username, hashedPassword);
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
            for (Map.Entry<String, String> entry : users.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
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
