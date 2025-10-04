package SocialNetworkPlatformLLD;

import SocialNetworkPlatformLLD.model.Comment;
import SocialNetworkPlatformLLD.model.Post;
import SocialNetworkPlatformLLD.model.User;
import SocialNetworkPlatformLLD.services.SocialNetweorkFacade;

public class SocialNetworkLLDMain {
    public static void main(String[] args) {
        SocialNetweorkFacade facadeService = SocialNetweorkFacade.getInstance();

        User alice = new User("alice", "a@gmail.com");
        User bob = new User("bob", "b@gmail.com");

        facadeService.addUser(alice);
        facadeService.addUser(bob);

        facadeService.addFriend(alice, bob);

        Post post = new Post(alice, "Test Post");

        facadeService.addPost(post);

        facadeService.like(post, bob);

        facadeService.comment(post, new Comment(bob, "Test Comment"));

        for(Post p : facadeService.generateFeed(alice.getId())){
            System.out.println("Post content:" + p.getContent());
        }
    }
}
