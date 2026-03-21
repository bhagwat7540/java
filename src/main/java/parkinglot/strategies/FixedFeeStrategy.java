package parkinglot.strategies;

public class FixedFeeStrategy implements FeeStrategy{

    @Override
    public int generateFee() {
        System.out.println("Fixed Fee Strategy");
        return 40;
    }
}
