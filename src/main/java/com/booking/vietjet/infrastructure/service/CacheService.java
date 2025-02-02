package com.booking.vietjet.infrastructure.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
@Slf4j
public class CacheService {

    private final RedisTemplate<Object, Object> redisTemplate;

    public void set(String key, Object value){
        redisTemplate.opsForValue().set(key, value);
    }

    public void set(String key, Object value, long ttl){
        log.info("Cache set key: {} value : {} with ttl {}", key, value, ttl);
        redisTemplate.opsForValue().set(key, value, ttl, TimeUnit.MILLISECONDS);
    }

    public Object get(String key){
        Object value =  redisTemplate.opsForValue().get(key);
        log.info("Cache get key: {}, value: {}", key, value);
        return value;
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }

}
