package util;

import enums.Direction;
import enums.Status;

import java.util.List;

public class DirectionAwareSchedulingStrategy implements SchedulingStrategy {
    public Elevator getElevator(ElevatorRequest elevatorRequest, List<Elevator> elevators) {
        int score=Integer.MAX_VALUE;
        Elevator selectedElevator=null;

        for(Elevator elevator: elevators){
            if(elevator.getStatus() != Status.WORKING){
                continue;
            }

            int distance=elevatorRequest.getRequestedFloor() - elevator.getCurrentFloor();

            if(elevator.getDirection() == Direction.IDLE){
                distance=Math.abs(distance);
            }
            else if(isOnTheWay(elevator, elevatorRequest) && elevator.getDirection()==elevatorRequest.getDirection()){
                distance=Math.abs(distance);
            }
            else if(isOnTheWay(elevator, elevatorRequest)){
                distance=Math.abs(distance) + 100;
            }
            else {
                distance=Math.abs(distance) + 1000;
            }

            if(distance<score) {
                score=distance;
                selectedElevator=elevator;
            }
        }

        return selectedElevator;
    }

    private boolean isOnTheWay(Elevator elevator, ElevatorRequest request) {
        int distance=request.getRequestedFloor() - elevator.getCurrentFloor();

        return (distance > 0 && elevator.getDirection() == Direction.UP)
                || (distance < 0 && elevator.getDirection() == Direction.DOWN);
    }
}
