package MeetingSchedulerLLD.entites;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.UUID;

public class MeetingRoom {
    
    private String id;
    private int capacity;
    NavigableSet<MeetingInterval> scheduledMeetings;

    public MeetingRoom(int capacity) {
        this.id = UUID.randomUUID().toString();
        this.capacity = capacity;
        this.scheduledMeetings = new TreeSet<>(Comparator.comparing((MeetingInterval interval)->interval.getStart()).thenComparing((MeetingInterval i)->i.getEnd()));
    }

    public boolean isAvailable(MeetingInterval interval, int meetingCapacity){
        MeetingInterval floor = scheduledMeetings.floor(interval);
        MeetingInterval ceiling = scheduledMeetings.ceiling(interval);
        if((floor != null && floor.getEnd().isAfter(interval.getStart())) || (ceiling != null && ceiling.getStart().isBefore(interval.getEnd())) || meetingCapacity > capacity) return false;
        return true;
    }

    public String getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public NavigableSet<MeetingInterval> getScheduledMeetings() {
        return scheduledMeetings;
    }

    public void schedule(MeetingInterval interval){
        scheduledMeetings.add(interval);
    }

    public void removeMeeting(MeetingInterval interval){
        scheduledMeetings.remove(interval);
    }

}
