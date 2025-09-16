package LinkedinLLD.services;
import LinkedinLLD.entites.Member;
import LinkedinLLD.entites.Notification;

public class NotificationService {
    public void send(Member member,Notification notification){
        member.update(notification);
    }    
}
