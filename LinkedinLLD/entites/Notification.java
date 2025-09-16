package LinkedinLLD.entites;

import java.time.LocalDateTime;

import LinkedinLLD.enums.NotificationType;

public class Notification {
    
    private LocalDateTime createdDate;
    private NotificationType notificationType;
    private String memberId;
    private String content;
    private boolean isRead;

    public Notification(String content, NotificationType type,String memberId){
        this.createdDate = LocalDateTime.now();
        this.memberId = memberId;
        this.content = content;
        this.notificationType = type;
        isRead = false;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getContent() {
        return content;
    }

    public boolean isRead() {
        return isRead;
    }

    public void markAsRead(){
        isRead = true;
    }
}
