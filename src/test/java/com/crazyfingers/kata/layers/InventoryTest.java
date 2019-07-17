package com.crazyfingers.kata.layers;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.crazyfingers.kata.inventory.Inventory;
import com.crazyfingers.kata.inventory.ItemFactory;
import com.crazyfingers.kata.items.Item;

public class InventoryTest {

    @Test
    public void loadItems() throws InterruptedException {
        List<Item> items = new ArrayList<Item>();
        items.add(ItemFactory.newItemInstance(ItemFactory.DEFAULT, 10, 20));
        items.add(ItemFactory.newItemInstance(ItemFactory.FM_PRO4, 2, 0));
        items.add(ItemFactory.newItemInstance(ItemFactory.FM_TCO4_LVC, 5, 7));
        items.add(ItemFactory.newItemInstance(ItemFactory.FUEL_LEVEL_SENSOR, 0, 80));
        Inventory inventory = new Inventory(items);
        assertEquals(4, inventory.getItems().size());
    }

    @Test
    public void processDay() throws InterruptedException {
        List<Item> items = new ArrayList<Item>();
        items.add(ItemFactory.newItemInstance(ItemFactory.DEFAULT, 10, 20));
        Inventory inventory = new Inventory(items);
        inventory.dailyUpdate();
        assertEquals(9, inventory.getItems().get(0).getSellIn());
        assertEquals(19, inventory.getItems().get(0).getQuality());
    }

}
