package ElevatorSystemLLD.stratergy;

import java.util.List;
import java.util.Optional;

import ElevatorSystemLLD.Elevator;
import ElevatorSystemLLD.entites.Request;
import ElevatorSystemLLD.enums.Direction;

public class NearestStratergy implements SelectionStratergy{

    @Override
    public Optional<Elevator> searchElevator(List<Elevator> elevators, Request request) {
        Elevator bestElevator = null;
        int minDist = Integer.MAX_VALUE;
        for(Elevator elevator : elevators){
            if(isSutable(elevator, request)){
                int min = Math.abs(elevator.getCurFloor() - request.getTargetFloor());
                if(min < minDist){
                    min = minDist;
                    bestElevator = elevator;
                }
            }
        }

        return Optional.of(bestElevator);
    }
    
    private boolean isSutable(Elevator elevator, Request request){
        if(elevator.getDirection() == Direction.IDEL){
            return true;
        }

        if(request.getDirection() == Direction.UP && elevator.getCurFloor() <= request.getTargetFloor()){
            return true;
        } else if(request.getDirection() == Direction.DOWN && elevator.getCurFloor() >= request.getTargetFloor()){
            return true;
        }
        return false;
    }
}
