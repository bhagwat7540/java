package vendingmachine;

import vendingmachine.entities.Inventory;
import vendingmachine.entities.Product;
import vendingmachine.enums.Coins;
import vendingmachine.states.IdleState;
import vendingmachine.states.VendingMachineState;

public class VendingMachine {
    private final static VendingMachine machine = new VendingMachine();
    private final Inventory inventory = new Inventory();
    private VendingMachineState vendingMachineState = new IdleState(this);
    private String selectedItemCode;
    private int balance;

    private VendingMachine(){
    }

    public static VendingMachine getInstance() {
        return machine;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void selectItem(String code) {
        vendingMachineState.selectProduct(code);
    }

    public void insertCoin(Coins coin) {
        vendingMachineState.insertCoin(coin);
    }

    public void dispense() {
        vendingMachineState.dispenseProduct();
    }

    public String getSelectedItemCode() {
        return selectedItemCode;
    }

    public void setSelectedItemCode(String selectedItemCode) {
        this.selectedItemCode = selectedItemCode;
    }

    public void setVendingMachineState(VendingMachineState vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public VendingMachineState getVendingMachineState() {
        return vendingMachineState;
    }

    public void addBalance(int value) {
        balance += value;
    }

    public void refundBalance() {
        System.out.println("Refunding: " + balance);
        balance = 0;
    }

    public int getBalance() {
        return balance;
    }

    public Product addItem(String code, String name, int price, int quantity) {
        Product product = new Product(code, name, price);
        inventory.addProduct(code, product, quantity);
        return product;
    }

    public void dispenseItem() {
        Product product = inventory.getProduct(selectedItemCode);
        if (balance >= product.getPrice()) {
            inventory.reduceStock(selectedItemCode);
            balance -= product.getPrice();
            System.out.println("Dispensed: " + product.getName());
            if (balance > 0) {
                System.out.println("Returning change: " + balance);
            }
        }
        reset();
    }

    public Product getSelectedProduct() {
        return inventory.getProduct(this.selectedItemCode);
    }

    public void reset() {
        this.selectedItemCode = null;
        this.balance = 0;
    }
}
