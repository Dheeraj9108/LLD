package SocialNetworkPlatformLLD.services;

import SocialNetworkPlatformLLD.model.User;
import SocialNetworkPlatformLLD.respository.UserRepository;

public class UserService {

    public UserService() {}

    public void addFriend(User user){
        UserRepository.getInstance().addUser(user);
    }

}
