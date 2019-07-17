package com.crazyfingers.kata.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import com.crazyfingers.kata.items.Item;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

@Repository
public class InventoryDAOImpl implements InventoryDAO {

    private static final String KEY = "Inventory";

    private RedisTemplate<String, Object> redisTemplate;
    private ValueOperations<String, Object> valueOperations;

    @Autowired
    public InventoryDAOImpl(RedisTemplate<String, Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init(){
        valueOperations = redisTemplate.opsForValue();
    }

    public void update(List<Item> items) {
        valueOperations.set(KEY, items);
    }

    public List<Item> get() {
        List<Item> items = (List<Item>) valueOperations.get(KEY);
        if (items == null) {
            items = new ArrayList<Item>();
        }
        return items;
    }

    public void delete() {
        redisTemplate.delete(KEY);
    }

}
