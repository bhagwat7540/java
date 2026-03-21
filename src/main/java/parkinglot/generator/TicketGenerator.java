package parkinglot.generator;

import parkinglot.parkingentities.ParkingSpot;
import parkinglot.parkingentities.ParkingTicket;
import parkinglot.vehicle.Vehicle;

import java.util.UUID;

public class TicketGenerator {
    public ParkingTicket generateTicker(Vehicle vehicle, ParkingSpot parkingSpot) {
        return new ParkingTicket(UUID.randomUUID().toString(), vehicle, parkingSpot);
    }
}
