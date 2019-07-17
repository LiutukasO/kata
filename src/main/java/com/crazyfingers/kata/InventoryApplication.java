package com.crazyfingers.kata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import com.crazyfingers.kata.inventory.Inventory;

@SpringBootApplication
@PropertySource("classpath:redis.properties")
public class InventoryApplication {

    @Autowired
    private Environment env; 

    public static void main(String[] args) {
        SpringApplication.run(InventoryApplication.class, args);
    }

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(env.getProperty("redis.host"));
        redisStandaloneConfiguration.setPort(Integer.parseInt(env.getProperty("redis.port")));
        JedisConnectionFactory jedisConFactory = new JedisConnectionFactory(redisStandaloneConfiguration);
        return jedisConFactory;
    }

    @Bean
    RedisTemplate< String, Object > redisTemplate() {
        final RedisTemplate< String, Object > redisTemplate =  new RedisTemplate< String, Object >();
        redisTemplate.setConnectionFactory( jedisConnectionFactory() );
        redisTemplate.setDefaultSerializer( new JdkSerializationRedisSerializer() );
        return redisTemplate;
    }

}