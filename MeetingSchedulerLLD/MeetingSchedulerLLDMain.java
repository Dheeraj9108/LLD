package MeetingSchedulerLLD;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import MeetingSchedulerLLD.entites.Meeting;
import MeetingSchedulerLLD.entites.User;
import MeetingSchedulerLLD.enums.MeetingDuration;

public class MeetingSchedulerLLDMain {
    public static void main(String[] args) {
        MeetingSchedulerSystem system = MeetingSchedulerSystem.getInstance();

        system.addRom(3);
        // MeetingRoom rm2 = system.addRom(5);

        User alice = system.createUser("alice"); 
        User bob = system.createUser("bob"); 
        User john = system.createUser("john"); 
        User rebeca = system.createUser("rebeca"); 
        User lucy = system.createUser("lucy");
        
        Set<User> participats = new HashSet<>(List.of(bob,john,rebeca)); 

        Meeting meeting = system.scheduleMeeting(alice.getId(), LocalDateTime.now(), MeetingDuration._30, participats);

        if(meeting != null){
            system.startMeeting(meeting.getId());
            system.endMeeting(meeting.getId());
        }
    }   
}
