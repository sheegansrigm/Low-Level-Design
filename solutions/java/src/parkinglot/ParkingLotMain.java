package parkinglot;

import parkinglot.vehicletype.MotorCycle;
import parkinglot.vehicletype.Car;
import parkinglot.vehicletype.Truck;
import parkinglot.vehicletype.Vehicle;
import parkinglot.*;
public class ParkingLotMain {
    public static void main(String[] args){
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addLevel(new Level(1,100));

        Vehicle car = new Car("CAR123");
        Vehicle motorCycle = new MotorCycle("Motor123");
        Vehicle truck = new Truck("Truck123");

        parkingLot.parkVehicle(truck);
        parkingLot.parkVehicle(motorCycle);
        parkingLot.parkVehicle(car);
        parkingLot.unParkVehicle(truck);
        parkingLot.displayAvailability();
    }
}
