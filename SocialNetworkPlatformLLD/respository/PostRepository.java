package SocialNetworkPlatformLLD.respository;

import java.util.HashMap;
import java.util.Map;

import SocialNetworkPlatformLLD.model.Comment;
import SocialNetworkPlatformLLD.model.Post;

public class PostRepository {
    private static PostRepository INSTANCE;
    private Map<String, Post> posts;

    private PostRepository() {
        posts = new HashMap<>();
    }

    public static PostRepository getInstance() {
        if (INSTANCE == null) {
            synchronized (PostRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new PostRepository();
                }
            }
        }
        return INSTANCE;
    }

    public void addPost(Post post) {
        posts.put(post.getId(), post);
    }

    public void addComment(Post post, Comment comment){
        post.addComment(comment);
    }
}
