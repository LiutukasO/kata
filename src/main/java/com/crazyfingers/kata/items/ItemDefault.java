package com.crazyfingers.kata.items;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemDefault implements Item {

    private static final long serialVersionUID = 3858568113127271636L;
    private String name;
    private int sellIn;
    private int quality;

    public ItemDefault (String name, int sellIn, int quality) {
        this.name = name;
        this.setSellIn(sellIn);
        this.setQuality(quality);
    }

    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sellIn;
    }

    @JsonProperty("sellIn")
    public void setSellIn(int sellIn) {
        this.sellIn = (sellIn < 0 ? 0 : sellIn); // Number of days we have to sell the item must >= 0. By logically :) 
    }

    public int getQuality() {
        return quality;
    }

    @JsonProperty("quality")
    public void setQuality(int quality) {
        // The Quality of an item is never negative
        // The Quality of an item is never more than 50
        if (quality <= 0) {
            this.quality = 0;
        } else if (quality >= 50) {
            this.quality = 50; 
        } else {
            this.quality = quality;
        }
    }

    protected void proccessDay() {
        this.setQuality(this.quality - 1);
        this.setSellIn(this.sellIn - 1);
    }

    public void updateDayStatus() {
        this.proccessDay();
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

}
