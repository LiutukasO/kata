package com.crazyfingers.kata.inventory;

import com.crazyfingers.kata.items.Item;

/*
 * Every new instance create new thread
 * and runs asynchronous item update.
 */
public class ItemAsyncProcessing extends Thread {

    private Item item;

    public ItemAsyncProcessing (Item item) {
        this.item = item;
        this.start();
    }

    @Override
    public void run() {
        this.item.updateDayStatus();
    }

}
