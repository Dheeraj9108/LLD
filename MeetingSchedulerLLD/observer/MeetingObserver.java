package MeetingSchedulerLLD.observer;

import MeetingSchedulerLLD.entites.Meeting;

public interface MeetingObserver {
    public void onUpdate(Meeting meeting);
}
