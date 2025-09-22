package ElevatorSystemLLD.state;

import ElevatorSystemLLD.Elevator;
import ElevatorSystemLLD.entites.Request;
import ElevatorSystemLLD.enums.Direction;
import ElevatorSystemLLD.enums.RequestSource;

public class Up implements ElevatorState{

    @Override
    public void move(Elevator elevator) {
        if(elevator.getUp().isEmpty()){
            elevator.setState(new Idel());
            return;
        }

        int nextFloor = elevator.getUp().first();
        elevator.setCurFloor(nextFloor);
        if(elevator.getCurFloor() == nextFloor){
            System.out.printf("Elevator %s stoped at %s \n",elevator.getId(), elevator.getCurFloor());
            elevator.getUp().pollFirst();
        }
    }

    @Override
    public void addRequest(Elevator elevator, Request request) {
        if(request.getSource() == RequestSource.INTERNAL){
            if(request.getTargetFloor() > elevator.getCurFloor()){
                elevator.getUp().add(request.getTargetFloor());
            }else{
                elevator.getDown().add(request.getTargetFloor());
            }
            return;
        }

        if(request.getDirection() == Direction.UP && request.getTargetFloor() >= elevator.getCurFloor()){
            elevator.getUp().add(request.getTargetFloor());
        } else if(request.getDirection() == Direction.DOWN){
            elevator.getDown().add(request.getTargetFloor());
        }
    }

    @Override
    public Direction getDirection() {
        return Direction.UP;
    }
    
}
