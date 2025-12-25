package MeetingSchedulerLLD.state;

import MeetingSchedulerLLD.entites.Meeting;
import MeetingSchedulerLLD.enums.MeetingStatus;

public class Inprogress implements MeetingState{

    @Override
    public void start(Meeting meeting) {
        System.out.println("Meeting is in progress");
    }

    @Override
    public void end(Meeting meeting) {
        meeting.setState(new Completed());
        meeting.setStatus(MeetingStatus.COMPLETED);
        meeting.getRoom().removeMeeting(meeting.getInterval());
    }
    
}
