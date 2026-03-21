package parkinglot.paymentmethods;

public class UpiPayment implements PaymentMethod{

    @Override
    public void pay() {
        System.out.println("UPI payment");
    }
}
