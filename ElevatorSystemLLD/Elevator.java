package ElevatorSystemLLD;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

import ElevatorSystemLLD.entites.Request;
import ElevatorSystemLLD.enums.Direction;
import ElevatorSystemLLD.observer.Display;
import ElevatorSystemLLD.observer.Observers;
import ElevatorSystemLLD.state.ElevatorState;
import ElevatorSystemLLD.state.Idel;

public class Elevator implements Runnable {
    private String id;
    private AtomicInteger curFloor;
    private ElevatorState state;
    private boolean isRunning;
    List<Observers> observers;

    private TreeSet<Integer> up;
    private TreeSet<Integer> down;

    public Elevator(String id) {
        this.id = id;
        up = new TreeSet<>();
        down = new TreeSet<>();
        state = new Idel();
        observers = Arrays.asList(new Display());
        curFloor = new AtomicInteger(1);
        notifyObserver();
        isRunning = true;
    }

    public void notifyObserver(){
        for(Observers observer : observers){
            observer.display(this);
        }
    }

    private void move() {
        state.move(this);
    }

    public void stop() {
        isRunning = false;
    }

    public void addRequest(Request request) {
        state.addRequest(this, request);
    }

    public void setState(ElevatorState state) {
        this.state = state;
        notifyObserver();
    }

    public void setCurFloor(int floor){
        this.curFloor = new AtomicInteger(floor);
    }

    @Override
    public void run() {
        while (isRunning) {
            move();
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public Direction getDirection() {
        return state.getDirection();
    }

    public String getId() {
        return id;
    }

    public int getCurFloor() {
        return curFloor.get();
    }

    public ElevatorState getState() {
        return state;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public TreeSet<Integer> getUp() {
        return up;
    }

    public TreeSet<Integer> getDown() {
        return down;
    }
}
