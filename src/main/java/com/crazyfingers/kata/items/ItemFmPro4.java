package com.crazyfingers.kata.items;

public class ItemFmPro4 extends ItemDefault implements Item {

    private static final long serialVersionUID = 3063353821024176907L;

    public ItemFmPro4 (String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void proccessDay() {
        // "FM-Pro4" actually increases in Quality the older it gets
        this.setQuality(this.getQuality() + 1);
        this.setSellIn(this.getSellIn() - 1);
    }

}
