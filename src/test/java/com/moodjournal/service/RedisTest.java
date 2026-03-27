package com.moodjournal.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.logging.Logger;

@SpringBootTest
@Slf4j
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void test(){
        redisTemplate.opsForValue().set("email2","jenny@gmail.com");
        Object o = redisTemplate.opsForValue().get(("email"));
        int a = 1;
    }

}
