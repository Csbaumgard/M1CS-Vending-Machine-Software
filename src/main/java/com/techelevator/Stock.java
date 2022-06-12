package com.techelevator;

import java.io.*;
import java.security.Key;
import java.text.DecimalFormat;
import java.util.*;

public class Stock {
    private Map<String, Items> itemMap = new HashMap<>();


    List<String> itemList = new ArrayList<>();
    public List<String> displayStock() {

        Set<String> keys = itemMap.keySet();
        for (String s : keys) {
            Items item = itemMap.get(s);
            StringBuffer itemString = new StringBuffer();
            DecimalFormat df = new DecimalFormat("###.00");
            itemString.append(item.getName() + " | ");
            itemString.append(item.getSlot() + " | ");
            itemString.append("$" + df.format((double)item.getPrice() / 100) + " | ");
            if (item.getStock() == 0) {
                itemString.append("SOLD OUT");
            } else {
                itemString.append(item.getStock());
                itemList.add(itemString.toString());
            }
        }
        return itemList;
    }


    public void purchaseMenuSelectProduct() {

        System.out.println("Please Enter Item Code (Example: A1)");
        Scanner slot = new Scanner(System.in);
        Items currentItem = itemMap.get(slot);

        String userProductChoice = slot.nextLine();

        System.out.println("You Chose " + userProductChoice);

        Set<String> keys = itemMap.keySet();
        for (String s : keys) {
            Items item = itemMap.get(s);
            StringBuffer itemString = new StringBuffer();
            DecimalFormat df = new DecimalFormat("###.00");
            itemString.append(item.getName() + " | ");
            itemString.append(item.getSlot() + " | ");
            itemString.append("$" + df.format((double) item.getPrice() / 100) + " | ");
            if (userProductChoice == "A1") {
                System.out.println(itemString.append(item.getName()));
            } else {
                itemString.append(item.getStock());
                itemList.add(itemString.toString());
            }


        }

    }
}
