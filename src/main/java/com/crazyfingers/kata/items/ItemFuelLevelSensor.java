package com.crazyfingers.kata.items;

public class ItemFuelLevelSensor extends ItemDefault implements Item {

    private static final long serialVersionUID = -6213875563902065250L;

    public ItemFuelLevelSensor (String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void proccessDay() {
        //legendary item, never has to be sold or decreases in Quality
    }

}
