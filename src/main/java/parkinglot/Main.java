package parkinglot;

import parkinglot.gate.EntryGate;
import parkinglot.gate.ExitGate;
import parkinglot.gate.Gate;
import parkinglot.generator.TicketGenerator;
import parkinglot.parkingentities.ParkingBuilding;
import parkinglot.parkingentities.ParkingFloor;
import parkinglot.parkingentities.ParkingSpot;
import parkinglot.parkingentities.ParkingTicket;
import parkinglot.paymentmethods.CashPayment;
import parkinglot.paymentmethods.PaymentMethod;
import parkinglot.strategies.*;
import parkinglot.vehicle.Car;
import parkinglot.vehicle.Vehicle;
import parkinglot.vehicle.VehicleSize;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ParkingSpot spot1 = new ParkingSpot(1, VehicleSize.SMALL);
        ParkingSpot spot2 = new ParkingSpot(2, VehicleSize.MEDIUM);

        ParkingStrategy nearestParkingStrategy = new NearestParkingStrategy();
        FeeStrategy fixedFeeStrategy = new FixedFeeStrategy();
        TicketGenerator ticketGenerator = new TicketGenerator();
        PaymentMethod paymentMethod = new CashPayment();

        Gate entryGate = new EntryGate(1, nearestParkingStrategy, fixedFeeStrategy, ticketGenerator);
        Gate exitGate = new ExitGate(1, paymentMethod);

        ParkingFloor floor1 = new ParkingFloor(1, List.of(spot1, spot2), entryGate, exitGate);
        FloorStrategy floorStrategy = new NearestFloorStrategy();

        ParkingBuilding building = new ParkingBuilding(List.of(floor1), floorStrategy);

        Vehicle car = new Car(1);
        ParkingFloor currFloor = building.findFloor();
        EntryGate currEntryGate = (EntryGate) currFloor.getEntryGate();
        ParkingSpot currSpot = currEntryGate.findSpot(currFloor.getParkingSpots());
        int currFee = currEntryGate.generateFee();
        ParkingTicket ticket = currEntryGate.generateTicket(car, currSpot);

        ExitGate currExitGate = (ExitGate) currFloor.getExitGate();
        currExitGate.exitVehicle(currSpot);
    }
}
