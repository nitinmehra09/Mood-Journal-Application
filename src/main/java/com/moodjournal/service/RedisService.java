package com.moodjournal.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private final ObjectMapper mapper = new ObjectMapper();

    // ✅ SAVE
    public <T> void set(String key, T value) {
        try {
            String json = mapper.writeValueAsString(value);
            redisTemplate.opsForValue().set(key, json);

        } catch (Exception e) {
            e.printStackTrace(); // IMPORTANT
        }
    }

//    get
    public <T> T get(String key, Class<T> entityClass) {
        try {

            String json = redisTemplate.opsForValue().get(key);

            if (json == null) {
                return null;
            }

            return mapper.readValue(json, entityClass);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // ✅ DELETE
    public void delete(String key) {
        try {
            redisTemplate.delete(key);
        } catch (Exception e) {
            log.error("Error deleting key", e);
        }
    }
}