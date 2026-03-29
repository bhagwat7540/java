package vendingmachine.enums;

public enum Coins {
    PENNY(1),
    NICKEL(5),
    DIME(10),
    QUARTER(25);

    private final int value;

    Coins(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
