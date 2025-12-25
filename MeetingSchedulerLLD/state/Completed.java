package MeetingSchedulerLLD.state;

import MeetingSchedulerLLD.entites.Meeting;

public class Completed implements MeetingState{

    @Override
    public void start(Meeting meeting) {
        System.out.println("Meeting is already completed");
    }
    
    @Override
    public void end(Meeting meeting) {
        System.out.println("Meeting is already completed");
    }
    
}
