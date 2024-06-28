package repository;

import utils.User;
import utils.UserRole;

import java.util.HashMap;
import java.util.Map;

public class Database {
    private Map<String, User> users = new HashMap<String,User>();
    private Map<String, User> tokens = new HashMap<String,User>();

    private static Database database_instance = null;

    private Database() {
        User user1 = new User();
        user1.setUsername("proma_1234");
        user1.setPassword("1234");
        user1.setRole(UserRole.CUSTOMER);
        users.put(user1.getUsername(), user1);
        tokens.put("CUSTOMER1234",user1);

        User user2 = new User();
        user2.setUsername("john_doe");
        user2.setPassword("1234");
        user2.setRole(UserRole.PET_RELINQUISHER);
        users.put(user2.getUsername(), user2);
        tokens.put("PET_RELINQUISHER1234",user2);
    }

    public Map<String, User> getTokens(){
        return tokens;
    }

    public Map<String, User> getUsers(){
        return users;
    }

    public static synchronized Database getInstance()
    {
        if (database_instance == null)
            database_instance = new Database();

        return database_instance;
    }
}
