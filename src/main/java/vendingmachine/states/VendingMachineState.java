package vendingmachine.states;

import vendingmachine.VendingMachine;
import vendingmachine.enums.Coins;

public abstract class VendingMachineState {
    final VendingMachine machine;

    public VendingMachineState(VendingMachine machine) {
        this.machine = machine;
    }

    public abstract void insertCoin(Coins coin);

    public abstract void selectProduct(String code);

    public abstract void dispenseProduct();

    public abstract void refund();
}
