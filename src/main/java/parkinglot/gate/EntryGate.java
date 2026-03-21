package parkinglot.gate;

import parkinglot.generator.TicketGenerator;
import parkinglot.parkingentities.ParkingSpot;
import parkinglot.parkingentities.ParkingTicket;
import parkinglot.strategies.FeeStrategy;
import parkinglot.strategies.ParkingStrategy;
import parkinglot.vehicle.Vehicle;

import java.util.List;

public class EntryGate extends Gate{
    private final ParkingStrategy parkingStrategy;
    private final FeeStrategy feeStrategy;
    private final TicketGenerator ticketGenerator;
    public EntryGate(int id, ParkingStrategy parkingStrategy, FeeStrategy feeStrategy, TicketGenerator ticketGenerator) {
        super(id);
        this.parkingStrategy = parkingStrategy;
        this.feeStrategy = feeStrategy;
        this.ticketGenerator = ticketGenerator;
    }

    public ParkingSpot findSpot(List<ParkingSpot> parkingSpots){
        return this.parkingStrategy.findAvailableSot(parkingSpots);
    }

    public int generateFee() {
        return feeStrategy.generateFee();
    }

    public ParkingTicket generateTicket(Vehicle vehicle, ParkingSpot spot) {
        return ticketGenerator.generateTicker(vehicle, spot);
    }
}
