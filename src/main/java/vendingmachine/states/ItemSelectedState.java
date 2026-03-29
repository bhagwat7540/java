package vendingmachine.states;

import vendingmachine.VendingMachine;
import vendingmachine.enums.Coins;

public class ItemSelectedState extends VendingMachineState {
    public ItemSelectedState(VendingMachine machine) {
        super(machine);
    }

    @Override
    public void insertCoin(Coins coin) {
        machine.addBalance(coin.getValue());
        System.out.println("Coin Inserted: " + coin.getValue());
        int price = machine.getSelectedProduct().getPrice();
        if (machine.getBalance() >= price) {
            System.out.println("Sufficient money received.");
            machine.setVendingMachineState(new HasMoneyState(machine));
        }
    }

    @Override
    public void selectProduct(String code) {
        System.out.println("Item Already Selected");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Pay Money First");
    }

    @Override
    public void refund() {
        machine.reset();
        machine.setVendingMachineState(new IdleState(machine));
    }
}
