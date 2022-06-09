package com.techelevator;

public class TestClass extends InventoryStock {


    public static void main(String[] args) {
        InventoryStock Potato_Crisps = new InventoryStock("Potato Crisps", "A1", 3.05, "Chip", 5);
        System.out.println(Potato_Crisps.getPrice());
    }
}
