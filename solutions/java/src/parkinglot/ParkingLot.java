package parkinglot;

import parkinglot.vehicletype.Vehicle;
import java.util.ArrayList;

public class ParkingLot {
    private static ParkingLot instance;
    private final ArrayList<Level> levels;

    private ParkingLot(){
        levels = new ArrayList();
    }

    public static synchronized ParkingLot getInstance(){
        if(instance == null){
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addLevel(Level level){
        levels.add(level);
    }

    public boolean parkVehicle(Vehicle vehicle){
        for(Level level: levels){
            if(level.parkVehicle(vehicle)){
                System.out.println("Vehicle parked successfully");
                return true;
            }
        }
        System.out.println("Could not park vehicle");
        return false;
    }

    public boolean unParkVehicle(Vehicle vehicle){
        for(Level level: levels){
            if(level.unParkVehicle(vehicle)){
                System.out.println("Vehicle unparked successfully");
                return true;
            }
        }
        System.out.println("Could not unpark vehicle");
        return false;
    }

    public void displayAvailability(){
        for(Level level: levels){
            level.displayAvailability();
        }
    }
}
