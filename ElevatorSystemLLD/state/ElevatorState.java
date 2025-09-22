package ElevatorSystemLLD.state;

import ElevatorSystemLLD.Elevator;
import ElevatorSystemLLD.entites.Request;
import ElevatorSystemLLD.enums.Direction;

public interface ElevatorState {
    public void move(Elevator elevator);
    public void addRequest(Elevator elevator, Request request);
    public Direction getDirection();
}
