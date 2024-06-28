package repository;

import utils.User;
import utils.UserRole;

import java.util.HashMap;
import java.util.Map;

public class Database {
    private Map<String, User> users = new HashMap<String,User>();
    private Map<String, User> tokens = new HashMap<String,User>();

    public Database() {
        User user1 = new User();
        user1.setUsername("proma_1234");
        user1.setPassword("1234");
        user1.setRole(UserRole.CUSTOMER);
        users.put(user1.getUsername(), user1);
        tokens.put("cus_1234",user1);

        User user2 = new User();
        user2.setUsername("john_doe");
        user2.setPassword("1234");
        user2.setRole(UserRole.PET_RELINQUISHER);
        users.put(user2.getUsername(), user2);
        tokens.put("rel_1234",user2);
    }

    public Map<String, User> getTokens(){
        return tokens;
    }

    public Map<String, User> getUsers(){
        return users;
    }
}
