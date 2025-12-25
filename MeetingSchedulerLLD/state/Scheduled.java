package MeetingSchedulerLLD.state;

import MeetingSchedulerLLD.entites.Meeting;
import MeetingSchedulerLLD.enums.MeetingStatus;

public class Scheduled implements MeetingState{

    @Override
    public void start(Meeting meeting) {
        meeting.setState(new Inprogress());
        meeting.setStatus(MeetingStatus.INPROGRESS);
    }

    @Override
    public void end(Meeting meeting) {
        System.out.println("Meeting is not started");
    }
    
}
