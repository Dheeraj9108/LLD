package LinkedinLLD.entites;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import LinkedinLLD.enums.NotificationType;
import LinkedinLLD.observer.Subject;

public class Post extends Subject{
    private String id;
    private Member auhtor;
    private LocalDateTime createdDate;
    private String content;
    private List<Like> likes;
    private List<Comment> comments;

    public Post(Member author,String content){
        this.id = UUID.randomUUID().toString();
        this.auhtor = author;
        this.createdDate = LocalDateTime.now();
        this.content = content;
        this.likes = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.observers.add(author);
    }

    public void addLike(Like like){
        this.likes.add(like);

        Notification notification = new Notification(like.getAuthor().getName()+" Liked your post", NotificationType.POST_LIKE, auhtor.getId());
        notifyObserver(notification);
    }

    public void addComment(Comment comment){
        this.comments.add(comment);

        Notification notification = new Notification(comment.getAuthor().getName()+" commented on your post", NotificationType.POST_COMMENT, auhtor.getId());
        notifyObserver(notification);
    }

    public String getId() {
        return id;
    }

    public Member getAuhtor() {
        return auhtor;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public String getContent() {
        return content;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void display(){
        System.out.printf("Post : %s created by %s Likes: %s \n", content,auhtor.getName(),likes.size());
    }
}
