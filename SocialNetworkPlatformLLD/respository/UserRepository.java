package SocialNetworkPlatformLLD.respository;

import java.util.HashMap;
import java.util.Map;

import SocialNetworkPlatformLLD.model.User;

public class UserRepository {
    private static UserRepository INSTANCE;
    private Map<String, User> users;

    private UserRepository() {
        users = new HashMap<>();
    }

    public static UserRepository getInstance() {
        if (INSTANCE == null) {
            synchronized (UserRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UserRepository();
                }
            }
        }
        return INSTANCE;
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public User getUesrById(String userId){
        return this.users.get(userId);
    }
}
