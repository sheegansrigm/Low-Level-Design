package parkinglot.vehicletype;
public class Vehicle {

    protected String lisencePlate;
    protected VehicleType type;

    public Vehicle(String lisencePlate, VehicleType type){
        this.type = type;
        this.lisencePlate = lisencePlate;
    }

    public VehicleType getType(){
        return this.type;
    }

    public String getLisencePlate(){
        return this.lisencePlate;
    }
}
