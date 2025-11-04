package CourseRegisterationSystemLLD.entities;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.UUID;

import CourseRegisterationSystemLLD.observer.CourseObserver;

public class CourseOffering {
    private String id;
    private Course course;
    private Professor professor;
    private TimeSlot timeSlot;
    private int capacity;
    private List<Student> registered = new ArrayList<>();
    private Queue<Student> waiting = new LinkedList<>();
    private List<CourseObserver> observers = new ArrayList<>();

    public CourseOffering(Builder builder) {
        this.id = UUID.randomUUID().toString();
        this.capacity = builder.capacity;
        this.course = builder.course;
        this.professor = builder.professor;
        this.timeSlot = builder.timeSlot;
    }

    public void addObserver(CourseObserver observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        observers.stream().forEach(observer -> observer.onUpdate(this));
    }

    public void register(Student student) {
        registered.add(student);
    }

    public boolean isFull() {
        return registered.size() >= capacity;
    }

    public void drop(Student student) {
        boolean wasFull = isFull();
        registered.remove(student);
        student.drop(this);
        if (wasFull && !isFull()) {
            notifyAllObservers();
        }
    }

    public Optional<Student> getNextFromWaitList() {
        return Optional.ofNullable(waiting.poll());
    }

    public static class Builder {
        private Course course;
        private Professor professor;
        private TimeSlot timeSlot;
        private int capacity;

        public Builder setCourse(Course course) {
            this.course = course;
            return this;
        }

        public Builder setCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public Builder setProfessor(Professor professor) {
            this.professor = professor;
            return this;
        }

        public Builder setTimeSlot(TimeSlot slot) {
            this.timeSlot = slot;
            return this;
        }

        public CourseOffering build() {
            return new CourseOffering(this);
        }
    }

    public String getId() {
        return id;
    }

    public Course getCourse() {
        return course;
    }

    public Professor getProfessor() {
        return professor;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getRegistered() {
        return registered;
    }

    public Queue<Student> getWaiting() {
        return waiting;
    }
}
