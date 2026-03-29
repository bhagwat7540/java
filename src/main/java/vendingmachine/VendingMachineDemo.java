package vendingmachine;

import vendingmachine.enums.Coins;

public class VendingMachineDemo {

    public static void main(String[] args) {
        VendingMachine machine = VendingMachine.getInstance();
        machine.addItem("A1","Coke",25,3);
        machine.addItem("A2","Pepsi",25,2);
        machine.addItem("B1","Water",10,5);

        System.out.println("Step 1: Select an item");
        machine.selectItem("A1");

        // Insert coins
        System.out.println("Step 2: Insert coins");
        machine.insertCoin(Coins.DIME); // 10
        machine.insertCoin(Coins.DIME); // 10
        machine.insertCoin(Coins.NICKEL); // 5

        System.out.println("Step 3: Dispense item");
        machine.dispense(); // Should dispense Coke

        // Select another item
        System.out.println("Step 4: Select another item");
        machine.selectItem("B1");

        // Insert more amount
        System.out.println("Step 5: Insert more than needed");
        machine.insertCoin(Coins.QUARTER); // 25

        // Try to dispense the product
        System.out.println("Step 6: Dispense and return change");
        machine.dispense();
    }


}
