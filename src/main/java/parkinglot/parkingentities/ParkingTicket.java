package parkinglot.parkingentities;

import parkinglot.vehicle.Vehicle;

public class ParkingTicket {
    private final String id;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;

    public ParkingTicket(String id, Vehicle vehicle, ParkingSpot parkingSpot) {
        this.id = id;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
    }
}
