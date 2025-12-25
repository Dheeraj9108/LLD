package MeetingSchedulerLLD.state;

import MeetingSchedulerLLD.entites.Meeting;

public interface MeetingState {
    public void start(Meeting meeting);
    public void end(Meeting meeting);
}
