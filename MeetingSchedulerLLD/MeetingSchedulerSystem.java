package MeetingSchedulerLLD;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import MeetingSchedulerLLD.entites.Meeting;
import MeetingSchedulerLLD.entites.MeetingInterval;
import MeetingSchedulerLLD.entites.MeetingRoom;
import MeetingSchedulerLLD.entites.User;
import MeetingSchedulerLLD.enums.MeetingDuration;
import MeetingSchedulerLLD.factory.MeetingIntervalFactory;

public class MeetingSchedulerSystem {
    private static MeetingSchedulerSystem INSTANCE;
    private Map<String,User> users;
    private Map<String,Meeting> meetings;
    private Map<String, MeetingRoom> rooms;
    
    private MeetingSchedulerSystem() {
        users =  new HashMap<>();
        meetings = new HashMap<>();
        rooms = new HashMap<>();
    } 

    public static MeetingSchedulerSystem getInstance(){
        if(INSTANCE == null){
            synchronized(MeetingSchedulerSystem.class){
                if(INSTANCE == null){  
                    INSTANCE = new MeetingSchedulerSystem(); 
                }
            }
        }
        return INSTANCE;
    }

    public User createUser(String name){
        User user = new User(name);
        users.put(user.getId(), user);
        return user;
    }

    public MeetingRoom addRom(int capacity){
        MeetingRoom room = new MeetingRoom(capacity);
        rooms.put(room.getId(), room);
        return room;
    }

    public synchronized Meeting scheduleMeeting(String userId, LocalDateTime start, MeetingDuration duration, Set<User> participants){
        User organizer = users.get(userId);

        MeetingInterval interval = MeetingIntervalFactory.getMeetingInterval(start, duration);
        if(interval == null) return null;
        // search for available room
        Optional<MeetingRoom> rm = rooms.values().stream().filter(room-> room.isAvailable(interval,participants.size())).findFirst();
        if(rm.isPresent()){
            // schedule meeting
            MeetingRoom room = rm.get();
            room.schedule(interval);
            Meeting meeting = new Meeting(interval, room, organizer, participants);
            meetings.put(meeting.getId(), meeting);
            return meeting;
        } else {
            System.out.println("No rooms Available");
            return null;
        }
    }

    public void startMeeting(String meetingId){
        Meeting meeting = meetings.get(meetingId);
        meeting.start();
    }

    public void endMeeting(String meetingId){
        Meeting meeting = meetings.get(meetingId);
        meeting.end();
    }
}
