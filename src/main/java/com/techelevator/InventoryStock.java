package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class InventoryStock {
    private String name;
    private String slot;
    private double price;
    private String type;
    private String[] nameArray;
    private String[] slotArray;
    private Double[] priceArray;
    private String[] typeArray;


    public InventoryStock(String name, String slot, double price, String type) {
        this.name = name;
        this.slot = slot;
        this.price = price;
        this.type = type;
    }

    public InventoryStock() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void populateInventory() {
        File csv = new File("vendingmachine.csv");
        try {
            Scanner fileScanner = new Scanner(csv);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] itemArray = line.split("\n");
                System.out.println(Arrays.toString(itemArray));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
