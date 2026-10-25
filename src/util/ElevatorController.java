package util;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
    private List<Elevator> elevators;
    int floorCount;
    private SchedulingStrategy schedulingStrategy;

    public ElevatorController(int elevatorCount, int floorCount){
        elevators=new ArrayList<>();
        this.floorCount=floorCount;

        for(int i=0; i<elevatorCount; i++){
            elevators.add(new Elevator(floorCount));
        }

        this.schedulingStrategy=new DirectionAwareSchedulingStrategy();
    }

    public void setSchedulingStrategy(SchedulingStrategy schedulingStrategy) {
        this.schedulingStrategy=schedulingStrategy;
    }

    public void scheduleRequest(ElevatorRequest elevatorRequest){
        Elevator elevator=schedulingStrategy.getElevator(elevatorRequest, elevators);

        if(elevator != null){
            elevator.addRequest(elevatorRequest);
        }
    }
}
