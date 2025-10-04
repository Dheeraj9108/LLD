package SocialNetworkPlatformLLD.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class User {
    private String id;
    private String name;
    private String email;
    private List<Post> posts;
    private Set<User> firends;

    public User(String name,String email){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        posts = new ArrayList<>();
        firends = new HashSet<>();
    }

    public void addFriend(User friend){
        firends.add(friend);
    }

    public void addPost(Post post){
        posts.add(post);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public Set<User> getFirends() {
        return firends;
    }

}
