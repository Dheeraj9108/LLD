package SocialNetworkPlatformLLD.services;

import java.util.List;

import SocialNetworkPlatformLLD.model.Post;
import SocialNetworkPlatformLLD.respository.UserRepository;
import SocialNetworkPlatformLLD.stratergy.Chronological;
import SocialNetworkPlatformLLD.stratergy.FeedGenerationStrategry;

public class FeedService {

    private FeedGenerationStrategry strategry;

    public FeedService() {
        this.strategry = new Chronological();
    }

    public List<Post> generateFeed(String userId) {
        return this.strategry.generateFeed(UserRepository.getInstance().getUesrById(userId));
    }

}
