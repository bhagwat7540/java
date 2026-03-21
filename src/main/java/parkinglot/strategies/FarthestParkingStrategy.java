package parkinglot.strategies;

import parkinglot.parkingentities.ParkingSpot;

import java.util.List;

public class FarthestParkingStrategy implements ParkingStrategy{
    @Override
    public synchronized ParkingSpot findAvailableSot(List<ParkingSpot> parkingSpotList) {
        System.out.println("Will return parking spot");
        return parkingSpotList.get(parkingSpotList.size()-1);
    }
}
