package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface restock {
    public default void restock() {
        List<InventoryStock> stockList = new ArrayList<>();
        File csv = new File("vendingmachine.csv");
        try (Scanner fileScanner = new Scanner(csv)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] lineArray = line.split("\\|");
                stockList.add(new InventoryStock(lineArray[1], lineArray[0], Double.parseDouble(lineArray[2]), lineArray[3], 5));
            }
            for (int i = 0; i < stockList.size(); i++) {
                System.out.println(stockList.get(i).getAll());
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
