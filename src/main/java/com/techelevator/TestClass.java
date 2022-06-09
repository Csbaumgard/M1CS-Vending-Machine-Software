package com.techelevator;

public class TestClass extends InventoryStock {
    public TestClass(String name, String slot, double price, String type) {
        super(name, slot, price, type);
    }

    public static void main(String[] args) {
        InventoryStock stock = new InventoryStock();
        stock.populateInventory();
    }
}
