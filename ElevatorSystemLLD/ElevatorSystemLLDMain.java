package ElevatorSystemLLD;

import ElevatorSystemLLD.enums.Direction;

public class ElevatorSystemLLDMain {
    public static void main(String[] args) throws InterruptedException {
        ElevatorSystem system = ElevatorSystem.getInstance(2);
        system.start();

        system.requestElevator(03, Direction.UP);
        Thread.sleep(100);
        
        system.selectFloor("E2",7);
        
        Thread.sleep(100);
        system.shutdown();
    }
}
