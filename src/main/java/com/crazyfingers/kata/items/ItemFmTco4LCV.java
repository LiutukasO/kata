package com.crazyfingers.kata.items;

public class ItemFmTco4LCV extends ItemDefault implements Item {

    private static final long serialVersionUID = 1319372503073470711L;

    public ItemFmTco4LCV (String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

/*
    "FM-Tco4 LCV" increases in Quality as it's SellIn value approaches:
    Quality increases by 2 when there are 10 days or less
                      by 3 when there are  5 days or less
    but Quality drops to 0 after the sell by date has passed
    Global rule: at the end of each day our system lowers both values for every item
*/
    @Override
    protected void proccessDay() {
        if      (this.getSellIn() == 0)  this.setQuality(0);
        else if (this.getSellIn() <= 5)  this.setQuality(this.getQuality() + 3);
        else if (this.getSellIn() <= 10) this.setQuality(this.getQuality() + 2);
        else this.setQuality(this.getQuality() - 1);
        this.setSellIn(this.getSellIn() - 1);
    }

}
