package LinkedinLLD.entites;

import java.time.LocalDateTime;

public class Like {
    private Member author;
    private LocalDateTime createdDate;
    public Like(Member member){
        this.createdDate = LocalDateTime.now();
        this.author = member;
    }
    public Member getAuthor() {
        return author;
    }
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }
}
