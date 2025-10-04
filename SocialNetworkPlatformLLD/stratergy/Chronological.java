package SocialNetworkPlatformLLD.stratergy;

import java.util.ArrayList;
import java.util.List;

import SocialNetworkPlatformLLD.model.Post;
import SocialNetworkPlatformLLD.model.User;

public class Chronological implements FeedGenerationStrategry{

    @Override
    public List<Post> generateFeed(User user) {
        List<Post> posts = new ArrayList<>(user.getPosts());
        for(User friend : user.getFirends()){
            posts.addAll(friend.getPosts());
        } 
        return posts.stream().sorted((a,b)->b.getCreatedDate().compareTo(a.getCreatedDate())).toList();
    }
    
}
