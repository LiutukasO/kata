package com.crazyfingers.kata.inventory;

import com.crazyfingers.kata.items.Item;
import com.crazyfingers.kata.items.ItemDefault;
import com.crazyfingers.kata.items.ItemFmPro4;
import com.crazyfingers.kata.items.ItemFmTco4LCV;
import com.crazyfingers.kata.items.ItemFuelLevelSensor;

public final class ItemFactory {

    public static final String DEFAULT = "Default";
    public static final String FM_PRO4 = "FM-Pro4";
    public static final String FM_TCO4_LVC = "FM-Tco4 LCV";
    public static final String FUEL_LEVEL_SENSOR = "Fuel level sensor";

    private ItemFactory() {
        // restrict instantiation
    }

    public static Item newItemInstance(String name, int sellIn, int quality) {
        Item item = null;
        if (ItemFactory.FM_PRO4.equalsIgnoreCase(name)) {
            item = new ItemFmPro4(name, sellIn, quality);
        } else if (ItemFactory.FM_TCO4_LVC.equalsIgnoreCase(name)) {
            item = new ItemFmTco4LCV(name, sellIn, quality);
        } else if (ItemFactory.FUEL_LEVEL_SENSOR.equalsIgnoreCase(name)) {
            item = new ItemFuelLevelSensor(name, sellIn, quality);
        } else {
            item = new ItemDefault(name, sellIn, quality);
        }
        return item;
    }
}
