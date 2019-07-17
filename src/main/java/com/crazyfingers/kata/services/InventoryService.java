package com.crazyfingers.kata.services;

import com.crazyfingers.kata.items.Item;

import java.util.List;

public interface InventoryService {

    List<Item> get();

    List<Item> set(List<Item> items);

    void delete();

    List<Item> process();

}
