package com.crazyfingers.kata.layers;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.crazyfingers.kata.inventory.Inventory;
import com.crazyfingers.kata.inventory.ItemFactory;
import com.crazyfingers.kata.items.Item;
import com.crazyfingers.kata.items.ItemDefault;

public class ItemTest {

    @Test
    public void minQuality() throws InterruptedException {
        Item item = new ItemDefault("Testing", 15, -10);
        assertEquals(0, item.getQuality());
    }

    @Test
    public void maxQuality() throws InterruptedException {
        Item item = new ItemDefault("Testing", 5, 123);
        assertEquals(50, item.getQuality());
    }

    @Test
    public void minSellIn() throws InterruptedException {
        Item item = new ItemDefault("Testing", -10, 123);
        assertEquals(0, item.getSellIn());
    }

    @Test
    public void dailyQualityOnItemDefault() throws InterruptedException {
        int sellIn  = 4;
        int quality = 10;

        Item item = ItemFactory.newItemInstance(ItemFactory.DEFAULT, sellIn, quality);
        List<Item> items = new ArrayList<Item>();
        items.add(item);
        Inventory inventory = new Inventory(items);

        for (int i = item.getSellIn(); i > 0; i--) {
            inventory.dailyUpdate();
        }

        assertEquals(quality-sellIn, inventory.getItems().get(0).getQuality());
    }

    @Test
    public void dailyQualityOnItemFmPro4() throws InterruptedException {
        int sellIn  = 4;
        int quality = 10;

        Item item = ItemFactory.newItemInstance(ItemFactory.FM_PRO4, sellIn, quality);
        List<Item> items = new ArrayList<Item>();
        items.add(item);
        Inventory inventory = new Inventory(items);

        for (int i = item.getSellIn(); i > 0; i--) {
            inventory.dailyUpdate();
        }

        assertEquals(quality+sellIn, inventory.getItems().get(0).getQuality());
    }

    @Test
    public void dailyQualityOnItemFmTco4LCV() throws InterruptedException {
        int sellIn  = 15;
        int quality = 10;

        Item item = ItemFactory.newItemInstance(ItemFactory.FM_TCO4_LVC, sellIn, quality);
        List<Item> items = new ArrayList<Item>();
        items.add(item);
        Inventory inventory = new Inventory(items);

        for (int i = item.getSellIn(); i > 0; i--) {
            inventory.dailyUpdate();
        }

        assertEquals(30, inventory.getItems().get(0).getQuality());
    }

    @Test
    public void dailyQualityOnItemFuelLevelSensor() throws InterruptedException {
        int sellIn  = 4;
        int quality = 10;

        Item item = ItemFactory.newItemInstance(ItemFactory.FUEL_LEVEL_SENSOR, sellIn, quality);
        List<Item> items = new ArrayList<Item>();
        items.add(item);
        Inventory inventory = new Inventory(items);

        for (int i = item.getSellIn(); i > 0; i--) {
            inventory.dailyUpdate();
        }

        assertEquals(quality, inventory.getItems().get(0).getQuality());
    }

    @Test
    public void dailySellInOnItemDefault() throws InterruptedException {
        int sellIn  = 4;
        int quality = 10;

        Item item = ItemFactory.newItemInstance(ItemFactory.DEFAULT, sellIn, quality);
        List<Item> items = new ArrayList<Item>();
        items.add(item);
        Inventory inventory = new Inventory(items);

        for (int i = item.getSellIn(); i > 0; i--) {
            inventory.dailyUpdate();
        }

        assertEquals(0, inventory.getItems().get(0).getSellIn());
    }

    @Test
    public void dailySellInOnItemFmPro4() throws InterruptedException {
        int sellIn  = 4;
        int quality = 10;

        Item item = ItemFactory.newItemInstance(ItemFactory.FM_PRO4, sellIn, quality);
        List<Item> items = new ArrayList<Item>();
        items.add(item);
        Inventory inventory = new Inventory(items);

        for (int i = item.getSellIn(); i > 0; i--) {
            inventory.dailyUpdate();
        }

        assertEquals(0, inventory.getItems().get(0).getSellIn());
    }

    @Test
    public void dailySellInOnItemFmTco4LCV() throws InterruptedException {
        int sellIn  = 4;
        int quality = 10;

        Item item = ItemFactory.newItemInstance(ItemFactory.FM_TCO4_LVC, sellIn, quality);
        List<Item> items = new ArrayList<Item>();
        items.add(item);
        Inventory inventory = new Inventory(items);

        for (int i = item.getSellIn(); i > 0; i--) {
            inventory.dailyUpdate();
        }

        assertEquals(0, inventory.getItems().get(0).getSellIn());
    }

    @Test
    public void dailySellInOnItemFuelLevelSensor() throws InterruptedException {
        int sellIn  = 4;
        int quality = 10;

        Item item = ItemFactory.newItemInstance(ItemFactory.FUEL_LEVEL_SENSOR, sellIn, quality);
        List<Item> items = new ArrayList<Item>();
        items.add(item);
        Inventory inventory = new Inventory(items);

        for (int i = item.getSellIn(); i > 0; i--) {
            inventory.dailyUpdate();
        }

        assertEquals(sellIn, inventory.getItems().get(0).getSellIn());
    }

}
