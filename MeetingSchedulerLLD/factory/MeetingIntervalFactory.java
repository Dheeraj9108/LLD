package MeetingSchedulerLLD.factory;

import java.time.LocalDateTime;

import MeetingSchedulerLLD.entites.MeetingInterval;
import MeetingSchedulerLLD.enums.MeetingDuration;

public class MeetingIntervalFactory {
    
    public static MeetingInterval getMeetingInterval(LocalDateTime start, MeetingDuration duration){
        switch (duration) {
            case _15:
                return new MeetingInterval(start, start.plusMinutes(15));
            case _30:
                return new MeetingInterval(start, start.plusMinutes(30));
            default:
                System.out.println("Meeting Duration is Not supported");
                return null;
        }
    } 
    
}
