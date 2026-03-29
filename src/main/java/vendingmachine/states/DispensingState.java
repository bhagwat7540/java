package vendingmachine.states;

import vendingmachine.VendingMachine;
import vendingmachine.enums.Coins;

public class DispensingState extends VendingMachineState{

    public DispensingState(VendingMachine machine) {
        super(machine);
    }

    @Override
    public void insertCoin(Coins coin) {
        System.out.println("Currently dispensing. Please wait.");
    }

    @Override
    public void selectProduct(String code) {
        System.out.println("Currently dispensing. Please wait.");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Currently dispensing. Please wait.");
    }

    @Override
    public void refund() {
        System.out.println("Currently dispensing. Please wait.");
    }
}
