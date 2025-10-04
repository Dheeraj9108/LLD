package SocialNetworkPlatformLLD.observer;

import SocialNetworkPlatformLLD.model.Comment;
import SocialNetworkPlatformLLD.model.Post;
import SocialNetworkPlatformLLD.model.User;

public class Usernotifier implements Observer{

    @Override
    public void onCreatePost(Post post) {
        User user =  post.getAuthor();
        for(User friend : user.getFirends()){
            System.out.printf("Notification to friend %s, %s created a post \n", friend.getName(), user.getName());
        }
    }

    @Override
    public void onLike(Post post, User user) {
        System.out.printf("Notification to %s, %s liked your post \n", post.getAuthor().getName(), user.getName());
    }
    
    @Override
    public void onComment(Post post, Comment comment) {
        System.out.printf("Notification to %s, %s commented your post \n", post.getAuthor().getName(), comment.getAuthor().getName());
    }
    
}
