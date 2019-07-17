package com.crazyfingers.kata.layers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.crazyfingers.kata.RestAbstractTest;
import com.crazyfingers.kata.inventory.ItemFactory;
import com.crazyfingers.kata.items.Item;

public class ControllerTest extends RestAbstractTest {

    @Test
    public void list() throws Exception {
       String uri = "/inventory";
       MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
          .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

       int status = mvcResult.getResponse().getStatus();
       assertEquals(200, status);
    }

    @Test
    public void set() throws Exception {
       String uri = "/inventory";
       Item[] items = new Item[] {
                   ItemFactory.newItemInstance(ItemFactory.DEFAULT, 6, 10),
                   ItemFactory.newItemInstance(ItemFactory.FM_PRO4, 5, 15),
                   ItemFactory.newItemInstance(ItemFactory.FM_TCO4_LVC, 8, 25),
                   ItemFactory.newItemInstance(ItemFactory.FUEL_LEVEL_SENSOR, 3, 35)
               };
       int arraySize = items.length;

       String inputJson = super.mapToJson(items);
       MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
          .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

       int status = mvcResult.getResponse().getStatus();
       assertEquals(200, status);
    }

    @Test
    public void delete() throws Exception {
        String uri = "/inventory";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

}
