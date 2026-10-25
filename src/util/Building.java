package util;

import enums.Direction;

import java.util.Scanner;

public class Building {
    private final ElevatorController elevatorController;

    public Building(int elevatorCount, int floorCount){
        elevatorController=new ElevatorController(elevatorCount, floorCount);
    }

    public void requestElevator(){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter current floor: ");
        int floor=sc.nextInt();

        System.out.println("Enter 1 for upward else 2: ");
        int direction=sc.nextInt();

        elevatorController.scheduleRequest(new ElevatorRequest(floor, direction==1 ? Direction.UP : Direction.DOWN));
    }
}
