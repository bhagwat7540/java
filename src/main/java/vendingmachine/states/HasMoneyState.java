package vendingmachine.states;

import vendingmachine.VendingMachine;
import vendingmachine.enums.Coins;

public class HasMoneyState extends VendingMachineState{
    public HasMoneyState(VendingMachine machine) {
        super(machine);
    }

    @Override
    public void insertCoin(Coins coin) {
        System.out.println("Already received full amount.");
    }

    @Override
    public void selectProduct(String code) {
        System.out.println("Item already selected.");
    }

    @Override
    public void dispenseProduct() {
        machine.setVendingMachineState(new DispensingState(machine));
        machine.dispense();
    }

    @Override
    public void refund() {
        machine.refundBalance();
        machine.reset();
        machine.setVendingMachineState(new IdleState(machine));
    }
}
