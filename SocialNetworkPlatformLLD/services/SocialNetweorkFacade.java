package SocialNetworkPlatformLLD.services;

import java.util.List;

import SocialNetworkPlatformLLD.model.Comment;
import SocialNetworkPlatformLLD.model.Post;
import SocialNetworkPlatformLLD.model.User;

public class SocialNetweorkFacade {
    private UserService userService;
    private PostService postService;
    private FeedService feedService;
    private static SocialNetweorkFacade INSATNCE;

    private SocialNetweorkFacade() {
        userService = new UserService();
        postService = new PostService();
        feedService = new FeedService();
    }

    public static SocialNetweorkFacade getInstance() {
        if (INSATNCE == null) {
            synchronized (SocialNetweorkFacade.class) {
                if (INSATNCE == null) {
                    INSATNCE = new SocialNetweorkFacade();
                }
            }
        }
        return INSATNCE;
    }

    public void addUser(User user) {
        userService.addFriend(user);
    }

    public void addPost(Post post) {
        postService.createPost(post);
    }

    public void addFriend(User a, User b) {
        a.addFriend(b);
        b.addFriend(a);
    }

    public void like(Post post, User user){
        postService.like(post, user);
    } 

    public void comment(Post post, Comment comment){
        postService.comment(post, comment);
    }

    public List<Post> generateFeed(String userId) {
        return feedService.generateFeed(userId);
    }
}
