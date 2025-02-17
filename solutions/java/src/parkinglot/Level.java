package parkinglot;

import java.util.ArrayList;

import parkinglot.vehicletype.ParkingSpot;
import parkinglot.vehicletype.Vehicle;
import parkinglot.vehicletype.VehicleType;

public class Level {
    private final int floor;
    private final ArrayList<ParkingSpot> parkingSpot;

    public Level(int floor,int numSpots){
        this.floor = floor;
        parkingSpot = new ArrayList(numSpots);

        //50% fo the spots for MotorCycle
        double spotsForMotorCycle = 0.5;

        //40% of the spots for Car
        double spotsForCar = 0.4;

        //10% of the spots for Truck
        double spotsForTruck = 0.1;

        //Calculate the number of spots for each type of the vehicle
        int numOfMotorCycleSpots = (int)(numSpots*spotsForMotorCycle);
        int numOfCarSpots = (int)(numSpots*spotsForCar);
        int numOfTruckSpots = (int)(numSpots*spotsForTruck);

        //Allocating the spots for each type of the vehicle
        for(int i=0;i<numOfMotorCycleSpots;i++){
            parkingSpot.add(new ParkingSpot(i, VehicleType.MOTORCYCLE));
        }

        for(int i=numOfMotorCycleSpots+1;i<numOfCarSpots+numOfMotorCycleSpots;i++){
            parkingSpot.add(new ParkingSpot(i, VehicleType.CAR));
        }

        for(int i=numOfMotorCycleSpots+numOfCarSpots+1;i<numSpots;i++){
            parkingSpot.add(new ParkingSpot(i, VehicleType.TRUCK));
        }
        
    }

    public synchronized boolean parkVehicle(Vehicle vehicle){
        for(ParkingSpot spot: parkingSpot){
            if(spot.isAvailable() && spot.getVehicleType()==vehicle.getType()){
                spot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unParkVehicle(Vehicle vehicle){
        for(ParkingSpot spot: parkingSpot){
            if(!spot.isAvailable() && spot.getParkedVehicle().equals(vehicle)){
                spot.unParkVehicle();
                return true;
            }
        }
        return false;
    } 

    public void displayAvailability(){
        System.out.println("Level: "+floor+" Availability:");
        for(ParkingSpot spot: parkingSpot){
            System.out.println("Spot Number: "+spot.getSpotNumber()+" : "+(spot.isAvailable()? "Available for " : "Occupied By ")+spot.getVehicleType());
        }
    }
}
