package com.crazyfingers.kata.inventory;

import java.util.ArrayList;
import java.util.List;

import com.crazyfingers.kata.items.Item;

public class Inventory {
    private int day;
    private List<Item> items;

    public Inventory() {
        this.day   = 0;
        this.items = new ArrayList<Item>();
    }

    public Inventory(List<Item> items) {
        this.day   = 0;
        this.setItems(items);
    }

    public void setItems(List<Item> items) {
        this.day   = 0;
        this.items = new ArrayList<Item>();
        for (Item item : items) {
            this.items.add(ItemFactory.newItemInstance(item.getName()
                                                     , item.getSellIn()
                                                     , item.getQuality()));
        }
    }

    public List<Item> getItems() {
        return items;
    }

/*
 *  Foreach and Stream API are convenient to work with Collections. You can write code faster. 
 *  But, when your system is stable and performance is a major concern, you should think about rewriting your loop.
 *  https://dzone.com/articles/iteration-over-java-collections-with-high-performa
 */

    public void dailyUpdate() throws InterruptedException {
        this.day++;
        List<Thread> threads = new ArrayList<Thread>();
        // asynchronously process all items
        for (Item item : items) {
            threads.add((Thread) new ItemAsyncProcessing(item));
        }
        // Wait until finish all threads
        for(Thread thread : threads){
            thread.join();
        }
    }


    private static String padLeft(String s, int n) {
        return String.format("%" + n + "s", s);  
    }

    private static String padLeft(int s, int n) {
        return String.format("%" + n + "s", s);  
    }

    private static String itemtoStringTable(Item item) {
        return "| " + padLeft(item.getName(), 20) + " |" + padLeft(item.getSellIn(), 10) + " |" + padLeft(item.getQuality(), 10) + " |";
    }

    public void printInventory() {
        System.out.println("------------------------------------------------");
        System.out.println("|                  Day : " + padLeft(this.day,3) + "                   |");
        System.out.println("|----------------------------------------------|");
        System.out.println("|         Name         |   SellIn  |  Quality  |");
        System.out.println("|----------------------------------------------|");
        for (Item item : this.items) {
            System.out.println(itemtoStringTable(item));
        }
        System.out.println();
    }

}
