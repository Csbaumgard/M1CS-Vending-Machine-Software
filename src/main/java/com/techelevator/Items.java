package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Items {
    private String name;
    private String slot;
    private int price;
    private int stock;

    public Items() {
    }

    public Items(String name, String slot, int price) {
        this.name = name;
        this.slot = slot;
        this.price = price;
        stock = 5;


    }


    public String getAll() {
        return getSlot() + ", " + getName() + " $" + getPrice() + " " +getStock();
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
