package parkinglot.parkingentities;

import parkinglot.vehicle.Vehicle;
import parkinglot.vehicle.VehicleSize;

public class ParkingSpot {
    private final int id;
    private final VehicleSize parkingSize;
    private boolean isSpotAvailable;
    private Vehicle parkedVehicle;

    public ParkingSpot(int id, VehicleSize parkingSize) {
        this.id = id;
        this.parkingSize = parkingSize;
        this.isSpotAvailable = true;
        this.parkedVehicle = null;
    }

    public int getId() {
        return id;
    }

    public VehicleSize getParkingSize() {
        return parkingSize;
    }

    public boolean isSpotAvailable() {
        return isSpotAvailable;
    }

    public void setSpotAvailable(boolean spotAvailable) {
        isSpotAvailable = spotAvailable;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void setParkedVehicle(Vehicle parkedVehicle) {
        this.parkedVehicle = parkedVehicle;
    }

    public void makeSpotFree() {
        this.isSpotAvailable = true;
        this.parkedVehicle = null;
    }
}
