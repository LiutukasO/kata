package com.crazyfingers.kata;

import java.util.ArrayList;
import java.util.List;

import com.crazyfingers.kata.inventory.Inventory;
import com.crazyfingers.kata.inventory.ItemFactory;
import com.crazyfingers.kata.items.Item;


public class TextTestFixture {

	public static void main(String[] args) throws InterruptedException {
        System.out.println("Hey! :)");

        List<Item> items = new ArrayList<Item>();
        items.add(ItemFactory.newItemInstance("Panic button", 10, 20));
        items.add(ItemFactory.newItemInstance("FM-Pro4", 2, 0));
        items.add(ItemFactory.newItemInstance("Temperature sensor", 5, 7));
        items.add(ItemFactory.newItemInstance("Fuel level sensor", 0, 80));
        items.add(ItemFactory.newItemInstance("Fuel level sensor", -1, 80));
        items.add(ItemFactory.newItemInstance("Fuel level sensor", 8, 8));
        items.add(ItemFactory.newItemInstance("FM-Tco4 LCV", 15, 20));
        items.add(ItemFactory.newItemInstance("FM-Tco4 LCV", 10, 49));
        items.add(ItemFactory.newItemInstance("FM-Tco4 LCV", 5, 49));

        Inventory inventory = new Inventory(items);

        int days = 7;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            inventory.printInventory();
            inventory.dailyUpdate();
        }
    }

}
