package MeetingSchedulerLLD.observer;

import java.util.ArrayList;
import java.util.List;

import MeetingSchedulerLLD.entites.Meeting;

public abstract class Subject {
    private List<MeetingObserver> observers;

    public Subject() {
        this.observers = new ArrayList<>();
    }

    protected void addObserver(MeetingObserver observer){
        observers.add(observer);
    }

    protected void notifyObservers(Meeting meeting){
        for(MeetingObserver observer:observers){
            observer.onUpdate(meeting);
        }
    }
}
