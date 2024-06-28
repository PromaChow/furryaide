package repository;

import authentication.User;

import java.util.HashMap;
import java.util.Map;
import authentication.UserRole;

public class UserRepository {
    private Map<String, User> users = new HashMap<String, User>();

    public UserRepository() {
        // Add some dummy users
        User customer = new User();
        customer.setUsername("proma@example.com");
        customer.setRole(UserRole.CUSTOMER);
        customer.setPassword("1234");
        users.put("proma@example.com", customer);

    }

    public User findByUsername(String username) {
        return users.get(username);
    }
}
