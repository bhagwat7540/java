package parkinglot.parkingentities;

import parkinglot.gate.Gate;

import java.util.List;

public class ParkingFloor {
    private final int id;
    private final List<ParkingSpot> parkingSpots;
    private final Gate entryGate;
    private final Gate exitGate;

    public ParkingFloor(int id, List<ParkingSpot> parkingSpots, Gate entryGate, Gate exitGate) {
        this.id = id;
        this.parkingSpots = parkingSpots;
        this.entryGate = entryGate;
        this.exitGate = exitGate;
    }

    public int getId() {
        return id;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public Gate getEntryGate() {
        return entryGate;
    }

    public Gate getExitGate() {
        return exitGate;
    }
}
