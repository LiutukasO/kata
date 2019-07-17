package com.crazyfingers.kata;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.crazyfingers.kata.layers.InventoryTest;
import com.crazyfingers.kata.layers.ItemTest; 

@RunWith(Suite.class)
@Suite.SuiteClasses({
    ItemTest.class,
    InventoryTest.class,
})

public class TestSuite {
}
