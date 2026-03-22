package com.moodjournal.controller;

import com.moodjournal.entities.User;
import com.moodjournal.service.UserLoginService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static org.bson.assertions.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AdminControllerTests {
    @Autowired
    private UserLoginService userLoginService;

    @Test
    @Disabled
    public void testing(){
        assertEquals(5,2+3);
    }
    @Test
    @Disabled
    public void booleanTesting(){
        assertTrue(5<2?false:true);
    }

    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "2,3,5"
    })
    @Disabled
    public void addition(int a, int b, int c){
        assertEquals(c,a+b);
    }

    @Test
    @Disabled
    public void getAllUser(){
        assertNotNull(userLoginService.getAll());
    }

}
