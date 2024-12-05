package mobile.users.repo;

import mobile.users.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private static Integer userID = 0;

    private static Map<String, User> users = new HashMap<>();

    public void add(User user) {
        users.put(user.name() + userID, user);
    }

    public static User getByID(String name) {
        return users.get(name);
    }
}
