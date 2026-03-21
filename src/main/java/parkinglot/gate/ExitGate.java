package parkinglot.gate;

import parkinglot.parkingentities.ParkingSpot;
import parkinglot.paymentmethods.PaymentMethod;

public class ExitGate extends Gate{
    private final PaymentMethod paymentMethod;
    public ExitGate(int id, PaymentMethod paymentMethod) {
        super(id);
        this.paymentMethod = paymentMethod;
    }

    public void exitVehicle(ParkingSpot spot) {
        paymentMethod.pay();
        spot.makeSpotFree();
    }
}
