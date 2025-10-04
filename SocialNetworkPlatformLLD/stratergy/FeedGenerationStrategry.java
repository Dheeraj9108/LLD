package SocialNetworkPlatformLLD.stratergy;

import java.util.List;

import SocialNetworkPlatformLLD.model.Post;
import SocialNetworkPlatformLLD.model.User;

public interface FeedGenerationStrategry {
    public List<Post> generateFeed(User user);
}
