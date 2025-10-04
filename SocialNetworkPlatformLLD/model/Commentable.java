package SocialNetworkPlatformLLD.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Commentable {
    private String id;
    private User author;
    private String content;
    private LocalDateTime createdDate;
    private List<Comment> comments;

    public Commentable(User author, String content){
        this.id = UUID.randomUUID().toString();
        this.comments = new ArrayList<>();
        this.author = author;
        this.content = content;
        createdDate = LocalDateTime.now();
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }

    public String getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public List<Comment> getComments() {
        return comments;
    }    
}
