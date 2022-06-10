package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {

    private String fileName = "vendingmachinse.csv";
    private File inventoryFile = new File(fileName);

    private List<String> createListOfEachLine() {
            List<String> listOfEachInventoryFileLine = new ArrayList<String>();

            try (Scanner scanFile = new Scanner(inventoryFile))  {
                while (scanFile.hasNextLine()) {
                    listOfEachInventoryFileLine.add(scanFile.nextLine());
                }
            }  catch (FileNotFoundException e) {

            }
            return listOfEachInventoryFileLine;
    }


    private List<String[]>  inventoryLineListAsArrayList()  {
        List<String[]> lineListArray = new ArrayList<String[]>();

        for(String currentLine :  createListOfEachLine()) {
            lineListArray.add(currentLine.split("\\|"));
        }
        return inventoryLineListAsArrayList();
    }

    // public createMapOfItemAndCode()
    // for loop
        // if index of item type = ("Chips")
                // Chips chip = new Chip()
}
