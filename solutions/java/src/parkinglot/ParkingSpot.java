package parkinglot;

import parkinglot.vehicletype.Vehicle;
import parkinglot.vehicletype.VehicleType;

public class ParkingSpot {
    private final int spotNumber;
    private final VehicleType vehicleType;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotNumber,VehicleType vehicleType){
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
    }

    public synchronized boolean isAvailable(){
        return parkedVehicle==null;
    }

    public synchronized void parkVehicle(Vehicle vehicle){
        if(isAvailable() && vehicle.getType()==vehicleType){
            parkedVehicle = vehicle;
        }
        else{
            throw new IllegalArgumentException("Invalid vehicle type or spot is already occupied");
        }
    }

    public synchronized void unParkVehicle(){
        parkedVehicle = null;
    }

    public int getSpotNumber(){
        return this.spotNumber;
    }

    public VehicleType getVehicleType(){
        return this.vehicleType;
    }

    public Vehicle getParkedVehicle(){
        return this.parkedVehicle;
    }
}
