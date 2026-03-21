package parkinglot.strategies;

import parkinglot.parkingentities.ParkingFloor;

import java.util.List;

public interface FloorStrategy {
    public ParkingFloor findFloor(List<ParkingFloor> parkingFloors);
}
