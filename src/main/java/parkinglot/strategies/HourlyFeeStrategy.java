package parkinglot.strategies;

public class HourlyFeeStrategy implements FeeStrategy{
    @Override
    public int generateFee() {
        System.out.println("Using Hourly fee strategy");
        return 100;
    }
}
