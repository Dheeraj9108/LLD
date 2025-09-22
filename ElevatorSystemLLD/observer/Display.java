package ElevatorSystemLLD.observer;

import ElevatorSystemLLD.Elevator;

public class Display implements Observers{

    @Override
    public void display(Elevator elevator) {
        System.out.printf("Display elevator %s at %s direction %s\n",elevator.getId(),elevator.getCurFloor(),elevator.getDirection());
    }
    
}
