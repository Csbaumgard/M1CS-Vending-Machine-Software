package com.techelevator;

import com.techelevator.view.Menu;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	// Purchase Menu Variables

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY= "Display Vending Machine Items";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Purchase";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Exit";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION };

	private final Menu menu;
	private final PurchaseMenu purchaseMenu;

	public VendingMachineCLI(Menu menu, PurchaseMenu purchaseMenu) {
		this.menu = menu;
		this.purchaseMenu = purchaseMenu;
	}


	public void allStock() {
		List<Items> stockList = new ArrayList<>();
		File csv = new File("vendingmachine.csv");
		try (Scanner fileScanner = new Scanner(csv)) {
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] lineArray = line.split("\\|");
				stockList.add(new Items(lineArray[1], lineArray[0], lineArray[2], lineArray[3], 5));
			}
			for (int i = 0; i < stockList.size(); i++) {
				System.out.println(stockList.get(i).getAll());
			}


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			switch (choice) {
				case MAIN_MENU_OPTION_DISPLAY_ITEMS:
					allStock();
				case MAIN_MENU_OPTION_PURCHASE:

					break;
				case MAIN_MENU_OPTION_EXIT:
					System.exit(0);
			}
		}
	}
}
