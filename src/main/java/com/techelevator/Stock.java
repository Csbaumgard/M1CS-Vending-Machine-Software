package com.techelevator;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Stock {
    private Map<String, Items> itemMap = new HashMap<>();

    public Stock(File csv) {
        try (Scanner fileScanner = new Scanner(csv)) {
            String line;
            while (fileScanner.hasNextLine()) {
                line = fileScanner.nextLine();
                String[] itemProperties;
                itemProperties = line.split("\\|");
                int price = (int)(Double.parseDouble(itemProperties[2]) * 100);
                itemMap.put(itemProperties[0], new Items(itemProperties[0], itemProperties[1], price));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<String> displayStock() {
        List<String> itemList = new ArrayList<>();
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

}
