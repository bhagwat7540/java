package parkinglot.strategies;

@FunctionalInterface
public interface FeeStrategy {
    public int generateFee();
}
