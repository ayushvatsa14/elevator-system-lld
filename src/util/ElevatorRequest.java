package util;

import enums.Direction;

public class ElevatorRequest {
    private int requestedFloor;
    private Direction direction;

    public ElevatorRequest(int requestedFloor, Direction direction){
        this.requestedFloor=requestedFloor;
        this.direction=direction;
    }

    public int getRequestedFloor() {
        return requestedFloor;
    }

    public Direction getDirection() {
        return direction;
    }
}
