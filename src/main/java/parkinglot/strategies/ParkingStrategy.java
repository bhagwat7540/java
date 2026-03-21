package parkinglot.strategies;

import parkinglot.parkingentities.ParkingSpot;

import java.util.List;

@FunctionalInterface
public interface ParkingStrategy {
    public ParkingSpot findAvailableSot(List<ParkingSpot> parkingSpotList);
}
