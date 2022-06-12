package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    List<Items> vendingMachineStock = new ArrayList<>(); // where all objects are created



    File csv = new File("vendingmachine.csv");

    public void fileReader(){  // Successfully splits file and we cane use index  0, 1, 2, 3 to reference each class of product type
        Scanner fileReader = null;
        try{
            fileReader = new Scanner(csv);
        }  catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

            while (fileReader.hasNextLine()) {
               // String splitByLine = fileScanner.nextLine();
                String line = fileReader.nextLine(); // String Array
                String[] productArray = line.split("\\|");
                if (productArray[3].equals("Chip")) {
                    vendingMachineStock.add(new Chip(productArray[0], productArray[1], Double.parseDouble(productArray[2])));
                } else if(productArray[3].equals("Candy")) {
                    vendingMachineStock.add(new Candy(productArray[0], productArray[1], Double.parseDouble(productArray[2])));
                }
                else if(productArray[3].equals("Gum")) {
                    vendingMachineStock.add(new Gum(productArray[0], productArray[1], Double.parseDouble(productArray[2])));
                } else if(productArray[3].equals("Drink")) {
                    vendingMachineStock.add(new Drink(productArray[0], productArray[1], Double.parseDouble(productArray[2])));
                }

            }
        }

        public void displayVendingItems(){
            for(Items vendingItems : vendingMachineStock){
                System.out.println(vendingItems.getSlot() + " | " + vendingItems.getName() + " | " + vendingItems.getPrice() + " | " + vendingItems.getStock());
            }
        }



}
