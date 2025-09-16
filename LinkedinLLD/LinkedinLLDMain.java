package LinkedinLLD;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import LinkedinLLD.entites.Comment;
import LinkedinLLD.entites.Education;
import LinkedinLLD.entites.Experience;
import LinkedinLLD.entites.Like;
import LinkedinLLD.entites.Member;
import LinkedinLLD.entites.Post;

public class LinkedinLLDMain {
    public static void main(String[] args) {
        LinkedinSystem system = LinkedinSystem.getInstance();

        Member alice = new Member.Builder("Alice","alice@gmail.com")
                                .setEducations(List.of(new Education("MITE", LocalDate.of(2019, 3, 12), LocalDate.of(2023, 3, 1))))
                                .setExperience(List.of(new Experience("ABC", "DEF", LocalDate.of(2021, 1, 2), LocalDate.of(2022, 1, 1))))
                                .setSummary("Full stack Engineer")
                                .build();

        Member bob = new Member.Builder("Bob","bon@gmail.com")
                                .setEducations(List.of(new Education("MITE", LocalDate.of(2019, 3, 12), LocalDate.of(2023, 3, 1))))
                                .setExperience(List.of(new Experience("ABC", "DEF", LocalDate.of(2021, 1, 2), LocalDate.of(2022, 1, 1))))
                                .setSummary("Full stack Engineer")
                                .build();

        system.register(alice);
        system.register(bob);

        String connectionId = system.sendConnection(alice, bob);

        bob.viewNotifications();
        
        system.acceptRequest(connectionId);
        
        alice.viewNotifications();
        
        Post post = system.createPost("Test Post", alice);
        
        post.addLike(new Like(bob));
        
        post.addComment(new Comment("Nice Post", bob, LocalDateTime.now()));
        
        alice.viewNotifications();
        
        system.viewFeed(alice);

        system.searchByName("Alice");
    }
}
