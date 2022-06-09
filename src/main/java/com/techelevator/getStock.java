package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public interface getStock {
    public default void populateInventory() {
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
