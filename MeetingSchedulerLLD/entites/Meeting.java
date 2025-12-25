package MeetingSchedulerLLD.entites;

import java.util.Set;
import java.util.UUID;

import MeetingSchedulerLLD.enums.MeetingStatus;
import MeetingSchedulerLLD.observer.Subject;
import MeetingSchedulerLLD.state.MeetingState;
import MeetingSchedulerLLD.state.Scheduled;

public class Meeting extends Subject{

    private String id;
    private MeetingInterval interval;
    private MeetingRoom room;
    private User organizer;
    private Set<User> participants;
    private MeetingState state;
    private MeetingStatus status;

    public Meeting(MeetingInterval interval, MeetingRoom room, User organizer,
            Set<User> participants) {
        this.id = UUID.randomUUID().toString();
        this.interval = interval;
        this.room = room;
        this.organizer = organizer;
        this.participants = participants;
        this.state = new Scheduled();
        this.status = MeetingStatus.SCHEDULED;
        addObserver(organizer);
        participants.forEach(participant->addObserver(participant));
        notifyObservers(this);
    }

    public String getId() {
        return id;
    }

    public void start(){
        state.start(this);
    }

    public void end(){
        state.end(this);
    }

    public void setState(MeetingState state){
        this.state = state;
    }

    public void setStatus(MeetingStatus status){
        this.status = status;
        notifyObservers(this);
    }

    public MeetingRoom getRoom() {
        return room;
    }

    public User getOrganizer() {
        return organizer;
    }

    public Set<User> getParticipants() {
        return participants;
    }

    public MeetingState getState() {
        return state;
    }

    public MeetingStatus getStatus() {
        return status;
    }

    public MeetingInterval getInterval() {
        return interval;
    }

}
