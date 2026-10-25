package util;

import enums.Direction;
import enums.Status;

import java.util.PriorityQueue;

public class Elevator {
    private Direction direction;
    private Status status;

    private int currentFloor;

    PriorityQueue<Integer> upRequests=new PriorityQueue<>();
    PriorityQueue<Integer> downRequests=new PriorityQueue<>((a, b) -> Integer.compare(b, a));

    public Elevator(int floorCount){
        direction=Direction.IDLE;
        status=Status.WORKING;
        currentFloor=0;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction){
        this.direction=direction;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status=status;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor=currentFloor;
    }

    public PriorityQueue<Integer> getUpRequests() {
        return upRequests;
    }

    public PriorityQueue<Integer> getDownRequests() {
        return downRequests;
    }

    public void addRequest(ElevatorRequest elevatorRequest){
        if(elevatorRequest.getRequestedFloor()>currentFloor){
            upRequests.offer(elevatorRequest.getRequestedFloor());
        }
        else if(elevatorRequest.getRequestedFloor()<currentFloor){
            downRequests.offer(elevatorRequest.getRequestedFloor());
        }
    }
}
