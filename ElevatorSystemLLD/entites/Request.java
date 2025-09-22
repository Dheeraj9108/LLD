package ElevatorSystemLLD.entites;

import ElevatorSystemLLD.enums.Direction;
import ElevatorSystemLLD.enums.RequestSource;

public class Request {
    private int targetFloor;
    private Direction direction;
    private RequestSource source;

    public Request(int targetFloor, Direction direction, RequestSource source){
        this.targetFloor = targetFloor;
        this.direction = direction;
        this.source = source;
    }

    public int getTargetFloor() {
        return targetFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public RequestSource getSource() {
        return source;
    }

}
