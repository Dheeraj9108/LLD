package LinkedinLLD.entites;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import LinkedinLLD.observer.NotificationObserver;

public class Member implements NotificationObserver {
    private String id;
    private String name;
    private String email;
    private Profile profile;
    private List<Notification> notifications;
    private Set<Member> conections;

    public Member(Builder builder){
        this.id = UUID.randomUUID().toString();
        this.name = builder.name;
        this.email = builder.email;
        this.profile = builder.profile;
        this.notifications = new ArrayList<>();
        this.conections = new HashSet<>();
    }

    public void addConnection(Member member){
        conections.add(member);
    }

    public static class Builder{
        private String name;
        private String email;
        private Profile profile;

        public Builder(String name,String email){
            this.name = name;
            this.email = email;
            this.profile = new Profile();
        }

        public Builder setSummary(String summary){
            profile.setSummary(summary);
            return this;
        }

        public Builder setEducations(List<Education> educations){
            profile.setEducations(educations);
            return this;
        }

        public Builder setExperience(List<Experience> experiences){
            profile.setExperiences(experiences);
            return this;
        }
        public Member build(){
            return new Member(this);
        }
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

    public Profile getProfile() {
        return profile;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public Set<Member> getConections() {
        return conections;
    }

    public void update(Notification notification){
        this.notifications.add(notification);
    }

    public void display(){
        System.out.printf("Name : %s Email %s",name,email);
    }

    public void viewNotifications(){
        notifications.forEach(notification->{
            if(!notification.isRead()){
                System.out.println(notification.getContent());
                notification.markAsRead();
            }
        });
    }
}
