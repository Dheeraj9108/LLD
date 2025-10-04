package SocialNetworkPlatformLLD.services;

import java.util.ArrayList;
import java.util.List;

import SocialNetworkPlatformLLD.model.Comment;
import SocialNetworkPlatformLLD.model.Post;
import SocialNetworkPlatformLLD.model.User;
import SocialNetworkPlatformLLD.observer.Observer;
import SocialNetworkPlatformLLD.observer.Usernotifier;
import SocialNetworkPlatformLLD.respository.PostRepository;

public class PostService {

    List<Observer> observers = new ArrayList<>();

    public PostService(){
        observers.add(new Usernotifier());
    }

    public void createPost(Post post) {
        PostRepository.getInstance().addPost(post);
        post.getAuthor().addPost(post);
        observers.forEach(observer-> observer.onCreatePost(post));
    }

    public void like(Post post, User user){
        observers.forEach(observer-> observer.onLike(post, user));
    }
    
    public void comment(Post post, Comment comment){
        PostRepository.getInstance().addComment(post,comment);
        observers.forEach(observer-> observer.onComment(post, comment));
    }


}
