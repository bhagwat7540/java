package parkinglot.strategies;

import parkinglot.parkingentities.ParkingSpot;

import java.util.List;

public class NearestParkingStrategy implements ParkingStrategy{
    @Override
    public synchronized ParkingSpot findAvailableSot(List<ParkingSpot> parkingSpotList) {
        System.out.println("Will return parking spot");
        return parkingSpotList.get(0);
    }
}
