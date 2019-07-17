package com.crazyfingers.kata.dao;

import java.util.List;

import com.crazyfingers.kata.items.Item;

public interface InventoryDAO {

    void update(List<Item> items);

    List<Item> get();

    void delete();
}
