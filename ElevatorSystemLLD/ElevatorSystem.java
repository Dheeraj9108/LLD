package ElevatorSystemLLD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import ElevatorSystemLLD.entites.Request;
import ElevatorSystemLLD.enums.Direction;
import ElevatorSystemLLD.enums.RequestSource;
import ElevatorSystemLLD.stratergy.NearestStratergy;
import ElevatorSystemLLD.stratergy.SelectionStratergy;

public class ElevatorSystem {
    private static ElevatorSystem INSTANCE; 
    private Map<String,Elevator> elevators;
    private ExecutorService service;
    private SelectionStratergy stratergy;

    private ElevatorSystem(int numOfElevators){
        elevators = new HashMap<>();
        service  = Executors.newFixedThreadPool(numOfElevators);

        for(int i = 0;i<numOfElevators;i++){
            Elevator elevator1 = new Elevator("E1");
            Elevator elevator2 = new Elevator("E2");
            elevators.put(elevator1.getId(), elevator1);
            elevators.put(elevator2.getId(), elevator2);
        }
        stratergy = new NearestStratergy();
    }

    public static ElevatorSystem getInstance(int numOfElevators){
        if(INSTANCE == null){
            synchronized(ElevatorSystem.class){
                if(INSTANCE == null){
                    INSTANCE = new ElevatorSystem(numOfElevators);
                }
            }
        }
        return INSTANCE;
    }

    public void start(){
        for(Elevator elevator : elevators.values()){
            service.submit(elevator);
        }
    }

    public void requestElevator(int floor, Direction direction){
        System.out.printf("EXTERNAL User at floor %s wants to got to %s\n",floor,direction);
        Request request = new Request(floor, direction, RequestSource.EXTERNAL);
        Optional<Elevator> elevator = stratergy.searchElevator(new ArrayList<>(elevators.values()), request);
        if(elevator.isPresent()){
            elevator.get().addRequest(request);
        } else {
            System.out.println("No elevator found");
        }
    }

    public void selectFloor(String elevatorId, int destinatinFloor){
        System.out.printf("INTERNAL User in elevator %s wants to go to %s\n",elevatorId,destinatinFloor);
        Elevator elevator = elevators.get(elevatorId);
        Request request = new Request(destinatinFloor, Direction.IDEL, RequestSource.INTERNAL);
        elevator.addRequest(request); 
    }

    public void shutdown(){
        service.shutdown();
        for(Elevator elevator : elevators.values()){
            elevator.stop();
        }
        try {
            if(!service.awaitTermination(10, TimeUnit.SECONDS)){
                service.shutdownNow();
            }
        } catch (Exception e) {
            service.shutdownNow();
        }
    }
}
