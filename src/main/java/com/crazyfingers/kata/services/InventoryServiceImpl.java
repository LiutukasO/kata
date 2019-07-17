package com.crazyfingers.kata.services;

import com.crazyfingers.kata.dao.InventoryDAO;
import com.crazyfingers.kata.inventory.Inventory;
import com.crazyfingers.kata.items.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    private InventoryDAO inventoryDAO;

    @Autowired
    public InventoryServiceImpl(InventoryDAO inventoryDAO) {
        this.inventoryDAO = inventoryDAO;
    }

    @Override
    public List<Item> get() {
        return this.inventoryDAO.get();
    }

    @Override
    public List<Item> set(List<Item> items) {
        // format Quality and SellIn values by Business rules: MIN, MAX, etc.
        Inventory inventory = new Inventory(items);
        items = inventory.getItems();
        this.inventoryDAO.update(items);
        return items;
    }

    @Override
    public void delete() {
        this.inventoryDAO.delete();
    }

    @Override
    public List<Item> process() {
        List<Item> items = this.inventoryDAO.get();
        Inventory inventory = new Inventory(items);
        try {
            inventory.dailyUpdate();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        items = inventory.getItems();
        this.inventoryDAO.update(items);
        return items;
    }

}
