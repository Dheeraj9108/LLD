package ElevatorSystemLLD.state;

import ElevatorSystemLLD.Elevator;
import ElevatorSystemLLD.entites.Request;
import ElevatorSystemLLD.enums.Direction;

public class Idel implements ElevatorState{

    @Override
    public void move(Elevator elevator) {
        if(!elevator.getUp().isEmpty()){
            elevator.setState(new Up());
        }

        if(!elevator.getDown().isEmpty()){
            elevator.setState(new Down());
        }
    }

    @Override
    public void addRequest(Elevator elevator, Request request) {
        if(elevator.getCurFloor() <= request.getTargetFloor()){
            elevator.getUp().add(request.getTargetFloor());
        } else if(elevator.getCurFloor() >= request.getTargetFloor()){
            elevator.getDown().add(request.getTargetFloor());
        }
    }

    @Override
    public Direction getDirection() {
        return Direction.IDEL;
    }
    
}
