package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class InventoryStock implements Stock {
    private String name;
    private String slot;
    private String price;
    private String type;
    private int stock = 5;
    List<InventoryStock> stockList = new ArrayList<>();

    public InventoryStock() {
    }

    public InventoryStock(String name, String slot, String price, String type, int stock) {
        this.name = name;
        this.slot = slot;
        this.price = price;
        this.type = type;
        this.stock = stock;
    }

    public String getAll() {
        return getSlot() + ", " + getName() + " $" + getPrice() + " " + getType() + " " +getStock();
    }

    public int getStock() {
        return stock;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    public void restock() {
        File csv = new File("vendingmachine.csv");
        try (Scanner fileScanner = new Scanner(csv)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] lineArray = line.split("\\|");
                slot = lineArray[0];
                name = lineArray[1];
                price = (lineArray[2]);
                type = lineArray[3];
                stock = 5;
                stockList.add(new InventoryStock(slot, name, price, type, stock));
                }
            System.out.println(stockList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
