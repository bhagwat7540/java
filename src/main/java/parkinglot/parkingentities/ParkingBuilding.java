package parkinglot.parkingentities;

import parkinglot.strategies.FloorStrategy;

import java.util.List;

public class ParkingBuilding {
    private final List<ParkingFloor> parkingFloors;
    private final FloorStrategy floorStrategy;

    public ParkingBuilding(List<ParkingFloor> parkingFloors, FloorStrategy floorStrategy) {
        this.parkingFloors = parkingFloors;
        this.floorStrategy = floorStrategy;
    }

    public ParkingFloor findFloor(){
       return this.floorStrategy.findFloor(parkingFloors);
    }
}
