package LinkedinLLD.entites;

import java.time.LocalDateTime;

public class Comment {
    private String content;
    private Member author;
    private LocalDateTime createdDate;
    public Comment(String content, Member author, LocalDateTime createdDate) {
        this.content = content;
        this.author = author;
        this.createdDate = createdDate;
    }
    public String getContent() {
        return content;
    }
    public Member getAuthor() {
        return author;
    }
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }
}
