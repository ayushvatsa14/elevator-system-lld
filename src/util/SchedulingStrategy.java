package util;

import java.util.List;

public interface SchedulingStrategy {
    Elevator getElevator(ElevatorRequest elevatorRequest, List<Elevator> elevators);
}
