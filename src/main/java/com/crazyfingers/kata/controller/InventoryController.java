package com.crazyfingers.kata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crazyfingers.kata.items.Item;
import com.crazyfingers.kata.services.InventoryService;

@Controller
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @RequestMapping("/")
    public String index() {
        return "redirect:/inventory";
    }

    @RequestMapping(value = "/inventory", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<Item>> list() {
        List<Item> items = inventoryService.get();
        return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
    }

    @RequestMapping(value = "/inventory", method = {RequestMethod.POST, RequestMethod.PUT})
    public @ResponseBody ResponseEntity<List<Item>> set(@RequestBody List<Item> items) {
        items = this.inventoryService.set(items);
        return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
    }

    @RequestMapping(value = "/inventory", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete() {
        inventoryService.delete();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/inventory/process", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<List<Item>> process() {
        List<Item> items = inventoryService.process();
        return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
    }

}
