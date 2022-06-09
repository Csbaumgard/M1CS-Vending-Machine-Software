package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class InventoryStock {
    private String name;
    private String slot;
    private double price;
    private String type;
    private int stock;


    public InventoryStock(String name, String slot, double price, String type, int stock) {
        this.name = name;
        this.slot = slot;
        this.price = price;
        this.type = type;
        this.stock = stock;
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

}
