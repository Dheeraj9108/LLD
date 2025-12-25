package MeetingSchedulerLLD.entites;

import java.util.UUID;

import MeetingSchedulerLLD.observer.MeetingObserver;

public class User implements MeetingObserver{
    
    private String id;
    private String name;
    
    public User(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    @Override
    public void onUpdate(Meeting meeting) {
        System.out.printf("[Notification] to %s meeting %s is %s \n", name,meeting.getId(),meeting.getStatus());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
