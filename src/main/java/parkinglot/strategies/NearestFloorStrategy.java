package parkinglot.strategies;

import parkinglot.parkingentities.ParkingFloor;

import java.util.List;

public class NearestFloorStrategy implements FloorStrategy{
    @Override
    public ParkingFloor findFloor(List<ParkingFloor> parkingFloors) {
        return parkingFloors.get(0);
    }
}
