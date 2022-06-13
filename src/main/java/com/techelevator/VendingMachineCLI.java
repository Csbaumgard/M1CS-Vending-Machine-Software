package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.Money;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};

	// Purchase Menu Variables

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
	String formattedDate = LocalDateTime.now().format(formatter);
	private final Menu menu;
	Scanner userInput = new Scanner(System.in);
	File inputFile = new File("vendingmachine.csv");
	FileReader fileReader = new FileReader();
	public double currentBalance;
	DecimalFormat df = new DecimalFormat("###.00");
	Money balance = new Money();
	private String getUserSlot;



	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void writeToLog(String getUserSlot, String getUserName) { // pass in  PURCHASE_MENU_OPTION_FEED_MONEY accordingly
		try (PrintWriter dataOutput = new PrintWriter(new FileOutputStream("log.txt", true))) {
			if (PURCHASE_MENU_OPTIONS.equals(PURCHASE_MENU_OPTION_FEED_MONEY))  {
				getUserName = PURCHASE_MENU_OPTION_FEED_MONEY;
				dataOutput.println(formattedDate + " "  + PURCHASE_MENU_OPTION_FEED_MONEY  + " $" + df.format(balance.getBalance()) + " $" + df.format(currentBalance));
			}
			if (PURCHASE_MENU_OPTIONS.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
				getUserName = PURCHASE_MENU_OPTION_FINISH_TRANSACTION;
				dataOutput.println(formattedDate + " "  + PURCHASE_MENU_OPTION_FINISH_TRANSACTION + " $" + df.format(balance.getBalance()) + " $" + df.format(currentBalance));
			}
			else  {
				dataOutput.println(formattedDate + " "  + getUserName + " " + getUserSlot + " $" + df.format(balance.getBalance()) + " $" + df.format(currentBalance)); //+ item  name + slot + money fed in + end balance);
			}
		} catch (FileNotFoundException e) {
			System.err.println("Cannot open file for writing");
		}

	}

	public void run() {
		fileReader.fileReader();
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			switch (choice) {
				case MAIN_MENU_OPTION_DISPLAY_ITEMS:
					fileReader.displayVendingItems();
					break;
				case MAIN_MENU_OPTION_PURCHASE:
					runPurchase();
					break;
				case MAIN_MENU_OPTION_EXIT:
					System.exit(0);
			}
		}
	}


	public void runPurchase() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

			switch (choice) {
				case PURCHASE_MENU_OPTION_FEED_MONEY:
					String feedMoney = PURCHASE_MENU_OPTION_FEED_MONEY;
					System.out.println("Current Balance: $" + df.format(currentBalance));
					balance.balanceClear();
					System.out.println("Please insert valid bills (1's, 2's, 5's, 10's) ");
					try {
						int nextBill = Integer.parseInt(userInput.nextLine());
						balance.addMoney(nextBill);
					} catch (Exception e) {
						System.out.println("Oops... something went wrong.");
					}
					currentBalance += balance.getBalance();
					System.out.println("Current Balance: $" + df.format(currentBalance));
					writeToLog(getUserSlot, feedMoney);
					break;
				case PURCHASE_MENU_OPTION_SELECT_PRODUCT:
					fileReader.displayVendingItems(); //run fileReader.displayVendingItems() again to  display,
					System.out.println("Current Balance: $" + df.format(currentBalance));
					System.out.println("Please enter item code for selection (Example: A1) ");
					String slot = userInput.nextLine().toUpperCase();
					getUserSlot = slot;

					if (currentBalance - fileReader.userProductPrice(slot) >= 0 && fileReader.getStockAgain(slot) > 0) {
						fileReader.userSelectProduct(slot);
						currentBalance -= fileReader.userProductPrice(slot);
					} else {
						System.out.println("Insufficient funds.");
					}
					System.out.println("Current Balance: $" + df.format(currentBalance));

					writeToLog(getUserSlot, fileReader.getItemName(slot));
					break;
				case PURCHASE_MENU_OPTION_FINISH_TRANSACTION:
					String finishTransaction = PURCHASE_MENU_OPTION_FINISH_TRANSACTION;
					System.out.println("Dispensing Change...");
					balance.dispenseChange(currentBalance);
					writeToLog(getUserSlot, finishTransaction);
					currentBalance = 0;
					run();

			}
		}
	}
}




