package vendingmachine.states;

import vendingmachine.VendingMachine;
import vendingmachine.enums.Coins;

public class IdleState extends VendingMachineState {
    public IdleState(VendingMachine machine) {
        super(machine);
    }

    @Override
    public void insertCoin(Coins coin) {
        System.out.println("Please select an item before inserting money.");
    }

    @Override
    public void selectProduct(String code) {
        if (!this.machine.getInventory().isProductAvailable(code)) {
            System.out.println("Item not available");
            return;
        }

        machine.setSelectedItemCode(code);
        machine.setVendingMachineState(new ItemSelectedState(machine));
        System.out.println("Item Selected");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("No item selected.");
    }

    @Override
    public void refund() {
        System.out.println("No money to refund.");
    }
}
