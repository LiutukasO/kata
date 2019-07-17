package com.crazyfingers.kata.items;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = ItemDefault.class)
public interface Item extends Serializable{

    public void updateDayStatus();

    public String getName();
    public void setName(String name);

    public int getSellIn();
    public void setSellIn(int sellIn);

    public int getQuality();
    public void setQuality(int quality);

    public String toString();

}
