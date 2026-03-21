package parkinglot.paymentmethods;

public class CashPayment implements PaymentMethod{
    @Override
    public void pay() {
        System.out.println("Cash payment");
    }
}
