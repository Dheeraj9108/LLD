package ElevatorSystemLLD.stratergy;

import java.util.List;
import java.util.Optional;

import ElevatorSystemLLD.Elevator;
import ElevatorSystemLLD.entites.Request;

public interface SelectionStratergy {
    public Optional<Elevator> searchElevator(List<Elevator> elevators, Request request);
}
