package SocialNetworkPlatformLLD.observer;

import SocialNetworkPlatformLLD.model.Comment;
import SocialNetworkPlatformLLD.model.Post;
import SocialNetworkPlatformLLD.model.User;

public interface Observer {
    public void onCreatePost(Post post);
    public void onLike(Post post, User user);
    public void onComment(Post post, Comment comment);
}
